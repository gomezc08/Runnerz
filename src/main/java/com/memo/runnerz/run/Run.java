package com.memo.runnerz.run;

import java.time.LocalDateTime;

// added dependency check on pom.xml line 38.
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run (
    Integer id,
    @NotEmpty
    String name,
    LocalDateTime startedOn,
    LocalDateTime endedOn,
    @Positive
    Integer miles,
    Location location
) {
    // ensure endedOn is after startedOn.
    public Run {
        if (startedOn != null && endedOn != null && !endedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("endedOn must be after startedOn");
        }
    }
}
