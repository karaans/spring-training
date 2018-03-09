package test.app;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class WelcomeImpl implements Welcome {

    @Override
    public String sayWelcome(String msg) {
        return "Welcome dev " + msg;
    }
}
