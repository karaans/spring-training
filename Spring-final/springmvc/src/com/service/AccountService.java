package com.service;

import com.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> fetchAll();

    void save(Account account);

    void transfer(int fromId, int toId, double amt) throws Exception;
}
