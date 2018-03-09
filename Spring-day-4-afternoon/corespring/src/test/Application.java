package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.app.Welcome;

public class Application {
    public static void main(String[] args) {

        /**
         * Since no config.xml is present
         * It's counterpart (configuration class) is provided as argument
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("dev");
        context.register(AppConfig.class);
        context.refresh();

        Welcome obj = context.getBean(Welcome.class);
        System.out.println(obj.sayWelcome("annotation config"));
    }
}
