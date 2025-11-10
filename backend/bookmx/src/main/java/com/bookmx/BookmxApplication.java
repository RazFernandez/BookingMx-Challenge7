package com.bookmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bookmx")
public class BookmxApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookmxApplication.class, args);
    }
}

