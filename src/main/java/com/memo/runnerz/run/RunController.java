/* 
Main HTTP methods:
- GET: grabs stuff.
- POST: creates stuff.
- PUT: updates stuff.
- DELETE: deletes stuff.
*/

package com.memo.runnerz.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    // using spring data jdbc to interact with the database instead of manually creating a jdbc client and doing stuff that way.
    private final SpringDataRunRepository runRepo;

    public RunController(SpringDataRunRepository runRepo) {
        this.runRepo = runRepo;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepo.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable int id) {
        Optional<Run> run = runRepo.findById(id);
        return run.orElse(null);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void createRun(@RequestBody Run run) {
        runRepo.save(run);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateRun(@RequestBody Run run, @PathVariable int id) {
        runRepo.save(run);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRun(@PathVariable int id) {
        runRepo.delete(runRepo.findById(id).get()); 
    }

    // optional thing i did to practice - finds run by location (look at SpringDataRunRepository.java).
    @GetMapping("/location/{location}")
    List<Run> findByLocation(@PathVariable String location) {
        return runRepo.findByLocation(location);
    }

    

    // // 1. GET: grabs run based on id.
    // @GetMapping("/{id}")
    // Run findById(@PathVariable int id) {        // pathvariable tells spring that int id is what goes in the "/{id}" part of the url above.
    //     Optional<Run> optionalRun = runRepo.findById(id);
    //     return optionalRun.orElse(null);
    // }

    // // 2. POST - creates stuff. 
    // // since we are posting a run, we need to pass in a json file so we use requestbody (the body being the json file with info on a run).
    // @PostMapping("")
    // @ResponseStatus(HttpStatus.CREATED)     // lets spring boot know that we have created a new run.
    // void createRun(@RequestBody Run run) {
    //     runRepo.createRun(run);
    // }

    // // 3. PUT - Updates stuff
    // @PutMapping("/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // void updateRun(@RequestBody Run run, @PathVariable int id) {
    //     runRepo.updateRun(run, id);   
    // }

    // // 4. DELETE - deletes run based on id.
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // @DeleteMapping("/{id}")
    // void deleteRun(@PathVariable int id) {
    //     runRepo.deleteRun(id);
    // }

    // // optional thing i did to practice.
    // @GetMapping("/miles/{miles}")
    // Run findByMiles(@PathVariable int miles) {
    //     return runRepo.findTimeMiles(miles);
    // }
}
