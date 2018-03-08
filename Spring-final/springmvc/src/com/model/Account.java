package com.model;

import com.sun.org.glassfish.gmbal.NameValue;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class Account {

    @Min(value = 100)
    private int id;

    @NotEmpty
    private String name;
    private double balance;

    public Account() {
    }

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
