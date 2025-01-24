package com.memo.runnerz.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

// kinda acts as a database; manages all the runs we have done so far/tracked.
// @Repository tells spring that this class is a repository; this means that it provides info on how we can update, delete, get values.
// ^^ but it doesn't actually do it. It just provides the methods to do so.
@Repository
public class RunRepositoryOLD {
    // playing around with @value annotation - attaches a value to a data variable.
    @Value("100")
    private int maxMiles;
    
    private List<Run> runs = new ArrayList<>();
    

    // GET - return a list of runs.
    List<Run> findAll() {
        return runs;
    }

    // POST - add new run.
    // @Valid ensures that the run object is valid.
    void createRun(@Valid @RequestBody Run r) { 
        System.out.println(maxMiles);
        runs.add(r);
    }

    // PUT - update run.
    // @Valid ensures that the run object is valid.
    void updateRun(@Valid @RequestBody Run run, Integer id) {
        Optional<Run> optionalRun = findById(id);
        if(!optionalRun.isEmpty()) {
            runs.remove(optionalRun.get());
            runs.add(run);
        }
        else {
            throw new RunNotFound(id);
        }
    }

    // DELETE - delete run.
    void deleteRun(Integer id) {
        Optional<Run> optionalRun = findById(id);
        optionalRun.ifPresent(run -> runs.remove(run));
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
            .filter(run -> run.id().equals(id))
            .findFirst();
    }

    Run findTimeMiles(Integer miles) {
        return runs.stream()
            .filter(run -> run.miles().equals(miles))
            .findFirst()
            .get();
    }

    // POST - (init) add new run.
    @PostConstruct
    private void init() {
        runs.add(new Run(1, 
            "First Run", 
            LocalDateTime.now(), 
            LocalDateTime.now().plus(1, ChronoUnit.HOURS), 
            5, 
            Location.OUTDOOR, 1));
        
        
        runs.add(new Run(2, 
            "Second Run", 
            LocalDateTime.now().plus(5, ChronoUnit.HOURS), 
            LocalDateTime.now().plus(6, ChronoUnit.HOURS), 
            4, 
            Location.INDOOR, 1));
    }
}
