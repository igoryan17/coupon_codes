package com.podliva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath*:webApplicationContext.xml")
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String args[]) {
        SpringApplication.run(App.class);
    }
}
