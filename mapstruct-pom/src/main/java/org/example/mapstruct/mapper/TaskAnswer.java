package org.example.mapstruct.mapper;

import java.time.LocalDateTime;

public class TaskAnswer {

    private int number;
    private String employeeName;
    private LocalDateTime date;

    public TaskAnswer() {
    }

    public TaskAnswer(int number, LocalDateTime date) {
        this.number = number;
        this.date = date;
    }

    public TaskAnswer(int number, String employeeName, LocalDateTime date) {
        this.number = number;
        this.employeeName = employeeName;
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "TaskAnswer{" +
                "number=" + number +
                ", employee='" + employeeName + '\'' +
                ", date=" + date +
                '}';
    }
}

