package com.controllers;

import com.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @RequestMapping("/add")
    public String addAccount(Model model) {
        model.addAttribute("account", new Account());
        return "addAccount";
    }

    @RequestMapping("/save")
    public String saveAccount(@ModelAttribute Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "addAccount";
        }

        System.out.println("ID: " + account.getId() + "\nName: " + account.getName() + "\nBalance: " + account.getBalance());

        return "index";
    }
}
