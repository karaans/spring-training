package com.controllers;

import com.model.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/accounts")
@SessionAttributes({"account"})
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/add")
    public String addAccount(Model model) {
        model.addAttribute("account", new Account());
        return "addAccount";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute @Valid Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "addAccount";
        }

        accountService.save(account);
        System.out.println("ID: " + account.getId() + "\nName: " + account.getName() + "\nBalance: " + account.getBalance());

        return "index";
    }

    @RequestMapping("/list")
    public String fetchAccountList(Model model){
        List<Account> accountList = accountService.fetchAll();
        model.addAttribute("accountList", accountList);
        return "accountList";
    }

    //http//..../accounts/transfer/from/to/amount
    //http//..../accounts/transfer/100/101/5000
    @RequestMapping("/transer/{fromId}/{toId}/{amt}")
    @ResponseBody
    public String transfer(@PathVariable("fromId") int fromId, @PathVariable("toId") int toId, @PathVariable("amt") double amt){
        try {
            accountService.transfer(fromId,toId,amt);
            return "Transfer Complete";
        } catch (Exception e){
            e.printStackTrace();
            return "Transfer Failed";
        }

    }
}
