package org.example.mapstruct.innermapper;

import java.time.LocalDateTime;

public class TaskAnswer {

    private int number;
    private EmployeeAnswer employee;
    private LocalDateTime date;

    public TaskAnswer() {
    }


    public TaskAnswer(int number, EmployeeAnswer employee, LocalDateTime date) {
        this.number = number;
        this.employee = employee;
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

    public EmployeeAnswer getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeAnswer employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "TaskAnswer{" +
                "number=" + number +
                ", employee='" + employee + '\'' +
                ", date=" + date +
                '}';
    }
}

