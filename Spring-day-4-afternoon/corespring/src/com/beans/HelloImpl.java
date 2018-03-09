package com.beans;

import com.aspects.Monitor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // default id = helloImpl -- in case of component scan
public class HelloImpl implements Hello {

    @Value("Annotation")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @Monitor
    public String sayHello() {
        return "Hello " + message;
    }
}
