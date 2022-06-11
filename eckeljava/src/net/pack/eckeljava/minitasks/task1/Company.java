package net.pack.eckeljava.minitasks.task1;

public class Company {

    private static Employee employee;

    public static void main(String[] args) {
        System.out.println(employee);
        if(employee == null){
            employee = new Employee();
        }
        System.out.println(employee);
    }
}

class Employee {

}
