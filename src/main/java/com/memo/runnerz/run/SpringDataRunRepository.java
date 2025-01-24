package com.memo.runnerz.run;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

// ListCrudRepository already has a lot of built in CRUD methods; don't need to define a jdbc client.
public interface SpringDataRunRepository extends ListCrudRepository<Run, Integer> {
    // by default, springdatarunrepository has all of listcrudreposityory's methods.
    // LOOK AT RunController.java last method for implementation.
    // let's say i wanted to add one that finds by location...
    @Query("SELECT * FROM run WHERE location = :location")
    List<Run> findByLocation(String location);      
}
