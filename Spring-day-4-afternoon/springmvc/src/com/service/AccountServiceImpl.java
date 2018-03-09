package com.service;

import com.model.Account;
import com.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> fetchAll() {
        return accountRepository.fetchAll();
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void transfer(int fromId, int toId, double amt) throws Exception {

        try {
            System.out.println("AccountServiceImpl.transfer");
            accountRepository.deposit(toId, amt);
            accountRepository.withdraw(fromId, amt);
        } catch (Exception e) {
            throw e;
        }
    }
}
