package test.app;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class WelcomeTestImpl implements Welcome {

    @Override
    public String sayWelcome(String msg) {
        return "Welcome test " + msg;
    }
}
