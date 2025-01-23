package com.memo.runnerz.run;
import java.time.LocalDateTime;

/* 
Can do this way or can use Run.java which uses records instead of a long java class.
*/

public class RunOld {
    Integer id;
    String name;
    LocalDateTime startedOn;
    LocalDateTime endedOn;
    Integer miles;
    Location location;

    public RunOld(Integer id, String name, LocalDateTime startedOn, LocalDateTime endedOn, Integer miles, Location location) {
        this.id = id;
        this.name = name;
        this.startedOn = startedOn;
        this.endedOn = endedOn;
        this.miles = miles;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
