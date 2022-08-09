package net.hairservice.entities;

import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DaySchedule {

    private long id;
    private Day day;
    private LocalTime fromTime;
    private LocalTime toTime;

    public DaySchedule(Day day, LocalTime fromTime, LocalTime toTime) {
        this.day = day;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }
}