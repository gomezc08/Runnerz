package com.memo.runnerz.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {
    
    @GetMapping("")
    public String defaultPage() {
        return "Welcome to the Run API!";
    }
}
