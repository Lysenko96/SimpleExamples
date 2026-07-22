package org.example.mapstruct.innermapper;

public class Task {

    private int number;

    private Employee employee;

    public Task() {
    }

    public Task(int number) {
        this.number = number;
    }

    public Task(int number, Employee employee) {
        this.number = number;
        this.employee = employee;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                ", employee=" + employee +
                '}';
    }
}
