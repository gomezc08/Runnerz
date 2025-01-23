package com.memo.runnerz;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public String message() {
        return "Welcome to SpringBoot!";
    }
}
