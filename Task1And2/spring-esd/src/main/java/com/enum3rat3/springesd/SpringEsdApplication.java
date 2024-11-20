package com.enum3rat3.springesd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringEsdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEsdApplication.class, args);
    }

}
