package net.pack.horstmann.extendz2;

public class Main {

    public static void main(String[] args) {
        Person p = new Manager("Mike", 2000);
        System.out.println(p.getName());
        Person p1 = ((Manager) p).getPersonInstance("Geru");
        Person p2 = new Manager(p1.getName(), 0);
        System.out.println(p2.getName() + " " + ((Manager) p2).getSalary());
        System.out.println(p.getName() + " " + ((Manager) p).getSalary());
    }
}

class Person {

    protected String name;

    Person(String name){
        this.name = name;
    }

    Person(){

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

class Manager extends Person {

    private int salary;

    Manager(String name, int salary){
        super(name);
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    public Person getPersonInstance(String name){
        Person p = new Person(name);
        //this.setName(name);
        return p;
    }
}
