package test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * For purely annotation based systems - no context.xml for Spring is present
 *
 * A Class is used for configuration -- denoted by @Configuration
 */
@Configuration
//@ComponentScan(basePackages = "test.app")
@ComponentScan
public class AppConfig {

}
