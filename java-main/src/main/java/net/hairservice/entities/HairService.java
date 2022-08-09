package net.hairservice.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HairService {

    private long id;
    private Client client;
    private Master master;
    private DaySchedule schedule;

    public HairService(Client client, Master master, DaySchedule schedule) {
        this.client = client;
        this.master = master;
        this.schedule = schedule;
    }
}