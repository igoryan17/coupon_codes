package com.podliva;

import com.podliva.web.services.coupons.CouponLoaderService;
import com.podliva.web.models.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath*:webApplicationContext.xml")
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String args[]) {
        SpringApplication.run(App.class);
    }

    @Bean
    public CommandLineRunner run(CouponLoaderService couponLoaderService) {
        return args -> {
            LOGGER.info("codes = {}", couponLoaderService.loadCodes(Provider.PAPA_JONS));
        };
    }
}
