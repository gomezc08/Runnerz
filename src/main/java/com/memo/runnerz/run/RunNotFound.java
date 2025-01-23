package com.memo.runnerz.run;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFound extends RuntimeException {
    public RunNotFound(Integer id) {
        super("Run not found with id: " + id);
    }
    
}
