package com.memo.runnerz.run;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.simple.JdbcClient;

@Repository
public class JdbcRunRepository {
    private final JdbcClient jdbcClient;

    // constructor (initalize JDBC).
    public JdbcRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    // GET.
    // 1. return a list of runs
    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM run")
            .query(Run.class)
            .list();
    }

    // 2. return a run based on id.
    public Optional<Run> findByID(int id) {
        return jdbcClient.sql("SELECT * FROM run WHERE id = :id")
            .param("id", id)
            .query(Run.class)
            .optional();
    }

    // POST.
    // 1. create a run.
    public void createRun(Run run) {
        jdbcClient.sql("INSERT INTO run (name, started_on, ended_on, miles, location) VALUES (?,?,?,?,?)")
            .params(List.of(run.name(), run.startedOn(), run.endedOn(), run.miles(), run.location().toString()))
            .update();
    }

    // PUT - update a run.
    public void updateRun(Run run, int id) {
        jdbcClient.sql("UPDATE run SET name = ?, started_on = ?, ended_on = ?, miles = ?, location = ? WHERE id = ?")
            .params(List.of(run.name(), run.startedOn(), run.endedOn(), run.miles(), run.location().toString(), id))
            .update();       
    }

    // DELETE.
    // 1. delete a run based on id.
    public void deleteRun(int id) {
        jdbcClient.sql("DELETE FROM run WHERE id = ?")
            .params(List.of(id))
            .update();
    }

    // HELPER FUNCTION.
    // save a list of runs.
    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::createRun);
    }
}