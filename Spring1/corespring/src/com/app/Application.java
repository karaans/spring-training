package com.app;

import com.aspects.Monitor;
import com.beans.Hello;
import com.beans.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Application {

    private static int count = 0;
    private Service service;

    @Autowired
    public Application(Service service) {
        this.service = service;
        System.out.println("Application : " + count);
        count++;
    }

    public static void main(String[] args) {

        //Load Spring Container
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        /*
        //Handle to a bean (by type)
        Hello hello = context.getBean(Hello.class);
        System.out.println("Result: " + hello.sayHello());
        */

        //Handle to a bean (by name)
        Hello hello = (Hello) context.getBean("helloImpl");
        System.out.println("Type of hello : " + hello.getClass().getName());
        System.out.println("Result : " + hello.sayHello() + "\n\n ******** \n");

        Application app = context.getBean(Application.class);
        app.printCustomerName();

        System.out.println("\n ******* \n");

        Application app2 = context.getBean(Application.class);
        app2.printCustomerName();

//        ((ClassPathXmlApplicationContext) context).close();
    }

    @Monitor
    public void printCustomerName() {
        System.out.println("Type of service : " +  service.getClass().getName());
        System.out.println("Customer Name: " + service.getFullName());

    }
}
