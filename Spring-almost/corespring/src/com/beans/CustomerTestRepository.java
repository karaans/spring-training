package com.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class CustomerTestRepository implements CustomerRepository {

    private static int count=0;
    public CustomerTestRepository (){
        System.out.println("Customer Test Repository : "+count);
        count++;
    }

    @Override
    public String getFirstName() {
        return "Virat";
    }

    @Override
    public String getLastName() {
        return "Kohli";
    }
}
