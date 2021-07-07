package com.example.transaction.configuration;

import com.example.transaction.model.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean
    public Transaction Chrome() {
        System.setProperty("webdriver.chrome.driver", "/Downloads/chromedriver_linux64/chromedriver");
        return new Transaction();
    }
}
