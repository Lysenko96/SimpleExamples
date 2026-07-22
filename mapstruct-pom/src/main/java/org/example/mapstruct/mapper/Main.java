package org.example.mapstruct.mapper;

public class Main {

    public static void main(String[] args) {
        Task task = new Task(1, new Employee("Name456"));
        TaskAnswer taskAnswer = TaskMapper.mapper.toTaskAnswer(task);
        System.out.println(taskAnswer);
    }
}
