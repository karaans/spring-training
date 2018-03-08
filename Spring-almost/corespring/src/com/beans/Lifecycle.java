package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class Lifecycle {

    @Autowired
    Hello hello;

    public Lifecycle(){
//        System.out.println("Lifecycle.Lifecycle: " + hello);
    }

    @PostConstruct
    public void init(){
//        System.out.println("Lifecycle.init : " + hello);
    }

    @PreDestroy
    public void destroy(){
//        System.out.println("Lifecycle.destroy");
    }
}
