package com.repository;

import com.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> fetchAll() {
        return jdbcTemplate.query("select * from account", new RowMapper<Account>() {

            @Override
            public Account mapRow(ResultSet resultSet, int index) throws SQLException {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setBalance(resultSet.getDouble("balance"));
                return account;
            }
        });
    }

    @Override
    public void save(Account account) {
        String insertSQL = "INSERT INTO ACCOUNT(id, name, balance) values (?,?,?)";
        int rowsAffected = jdbcTemplate.update(insertSQL, account.getId(), account.getName(), account.getBalance());
        System.out.println("AccountRepositoryImpl.save | rowsAffected : " + rowsAffected);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deposit(int id, double amt) throws Exception {
        String updateSQL = "UPDATE ACCOUNT SET BALANCE = BALANCE + ? WHERE ID = ?";
        int rowsAffected = jdbcTemplate.update(updateSQL, amt, id);

        if(rowsAffected != 1){
            throw new Exception("Deposit Failed");
        }
        System.out.println("AccountRepositoryImpl.deposit | rowsAffected : " + rowsAffected);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void withdraw(int id, double amt) throws Exception {
        String updateSQL = "UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE ID = ? AND BALANCE > ?";
        int rowsAffected = jdbcTemplate.update(updateSQL, amt, id, amt);

        if(rowsAffected != 1){
            throw new Exception("Withdraw Failed.");
        }
        System.out.println("AccountRepositoryImpl.withdraw | rowsAffected : " + rowsAffected);
    }

}
