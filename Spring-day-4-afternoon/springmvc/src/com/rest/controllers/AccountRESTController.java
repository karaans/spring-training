package com.rest.controllers;

import com.model.Account;
import com.model.AccountList;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/service")
public class AccountRESTController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello(@RequestParam String msg) {
        return "Hello " + msg;
    }

    /**
     * Marshals JAVA object to XML format (using JAX-B library)
     * <p>
     * For XML mapping - Need to add @XmlRootElement to AccountList class
     *
     * @return
     */
    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public AccountList getAccounts() {
        AccountList list = new AccountList();
        list.setAccounts(accountService.fetchAll());
        return list;
    }

    @RequestMapping(value = "/accountsJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountList getAccountsJSON() {
        AccountList list = new AccountList();
        list.setAccounts(accountService.fetchAll());
        return list;
    }

    /**
     * Provides multiple representations(XML/JSON) of the data to be returned
     *
     * @return XML / JSON based on Request Header 'Accept'
     * Accept: application/json --> returns JSON
     * Accept: application/xml  --> returns XML
     */
    @RequestMapping(value = "/accountsALL", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public AccountList getAccountsALL() {
        AccountList list = new AccountList();
        list.setAccounts(accountService.fetchAll());
        return list;
    }

    /**
     * Gets account by ID provided in path (.../account/{id})
     *
     * For XML mapping - Need to add @XmlRootElement to Account class
     *
     * @param id
     * @return XML / JSON based on Request Header 'Accept'
     * Accept: application/json --> returns JSON
     * Accept: application/xml  --> returns XML
     */
    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Account getAccountById(@PathVariable("id") int id) {
        List<Account> accounts = accountService.fetchAll();

        for (Account acc : accounts) {
            if (id == acc.getId()) {
                return acc;
            }
        }
        return null;
    }

    /**
     * Handles error if ID is not found -- sends a BAD response (error 404)
     *
     * @param id
     * @return ResponseEntity
     * if ID found -- return Account object and GOOD (HttpStatus.OK) response
     * else        -- return BAD (Error 404) response
     */
    @RequestMapping(value = "/accountErr/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Account> getAccountByIdWithError(@PathVariable("id") int id) {
        List<Account> accounts = accountService.fetchAll();

        for (Account acc : accounts) {
            if (id == acc.getId()) {
                return new ResponseEntity<Account>(acc, HttpStatus.OK);
            }
        }

        /**
         * ResponseEntity.notFound() returns a builder
         * We need to call build() on it create/build the response
         */
        return ResponseEntity.notFound().build();
    }

    /**
     * Create New Account and handle errors:
     * 1. ID not valid
     * 2. Account creation failed
     *
     * @param account
     * @return
     */
    @RequestMapping(value = "/accounts", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> createAccount(@RequestBody Account account) {

        if (account.getId() <= 100) {
            return ResponseEntity.notFound().build();
        }
        try {
            accountService.save(account);
            return ResponseEntity.created(new URI("/accounts/" + account.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
