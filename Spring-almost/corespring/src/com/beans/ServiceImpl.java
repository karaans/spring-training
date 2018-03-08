package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ServiceImpl implements Service {

    private static int count = 0;

    @Autowired
    @Qualifier("customerRepo")
    private CustomerRepository repository;

    public ServiceImpl() {
        System.out.println("ServiceImpl : " + count);
        count++;
    }

    @Override
    public String getFullName() {
        return repository.getFirstName() + " " + repository.getLastName();
    }

    /*public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }*/
}
