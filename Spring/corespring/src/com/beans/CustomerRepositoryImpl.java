package com.beans;

import org.springframework.stereotype.Component;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String getFirstName(){
        return "First";
    }

    @Override
    public String getLastName(){
        return "Last";
    }
}
