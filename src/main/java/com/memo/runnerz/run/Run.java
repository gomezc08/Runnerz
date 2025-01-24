package com.memo.runnerz.run;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

// added dependency check on pom.xml line 38.
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run (
    @Id
    Integer id,
    @NotEmpty
    String name,
    LocalDateTime startedOn,
    LocalDateTime endedOn,
    @Positive
    Integer miles,
    Location location,
    @Version
    Integer version
) {
    // ensure endedOn is after startedOn.
    public Run {
        if (startedOn != null && endedOn != null && !endedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("endedOn must be after startedOn");
        }
    }
}
