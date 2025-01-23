package com.memo.runnerz.run;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
/*
CommandLineRunner: Spring Boot interface that allows you to run code after the application context is loaded 
and before the Spring Application run method is completed. 

This means that after the application context is loaded, the run method is called! So in the run method, we basically
just initalized our database with whatever is in the data.json file.
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RunJsonLoader implements CommandLineRunner {
    private final RunRepo runRepo;
    private final ObjectMapper objectMapper;
    private static final Logger log = LoggerFactory.getLogger(RunJsonLoader.class);

    // constructor.
    public RunJsonLoader(RunRepo runRepo, ObjectMapper objectMapper) {
        this.runRepo = runRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    // run method: loads json file.
    public void run(String... args) throws Exception {
        // loads json file.
        log.info("Loading runs from data.json");
        Run[] runs = objectMapper.readValue(getClass().getResourceAsStream("/data.json"), Run[].class);
        for (Run run : runs) {
            runRepo.createRun(run);
        }
        log.info("Loaded runs from data.json");
    }
}