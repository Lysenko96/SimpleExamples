package info.lysenko.anton;
public class Main {
    public static void main(String[] args) {

        //sdfsdfsf
        // \u000a System.out.println("sdfs");
        System.out.println(new Main().new A<String>("str"));
    }

    private class A<T> {

        T type;

        A(){}

        A(T type){
            this.type = type;
        }

        public <T extends A & B> void show(T value){
            System.out.println(value);
        }

        @Override
        public String toString() {
            return "A{" +
                    "type=" + type +
                    '}';
        }
    }

    interface B {


public class Main {

    public static void main(String[] args) {

        Employee e = new Employee(1,null,"last");
        Employee e1 = new Employee(2,null,"last");
        System.out.println(e.getFirstName().equals(e1.getFirstName()));
        //List<Employee> list = new ArrayList<>(Arrays.asList(new Employee(1,"fist","last"), new Employee(2,"name","surname"), new Employee(3,"myname", "noname")));
        List<Employee> list = new ArrayList<>();

        list.add(e);
        System.out.println(list.contains(e1));
       // List<String> list = new ArrayList<>();
//        list.add("sdfaf");
//        list.add("sdfasdfsf");
       // list.add(null);
       // System.out.println(list);
        //List<String> newList = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        //System.out.println(newList);
       /// List<Employee> newList2 = list.stream().sorted(Comparator.comparing(Employee::getLastName, Comparator.nullsFirst(Comparator.naturalOrder()))).collect(Collectors.toList());
       // System.out.println(newList2);

//        Thread t1 = new Thread(new MyRunnable());
//        long start = System.currentTimeMillis();
//        t1.start();
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(2000);
//            System.out.println(1);
//            System.out.println(Thread.currentThread().getName());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - start);
    }
}

class Employee {

    private int id;
    private String firstName;
    private String lastName;

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
>>>>>>> f607f6bebd8950eb70fe88e233d2b817fdbe1d73
    }
}


<<<<<<< HEAD
=======
class MyRunnable implements Runnable {
    @Override
    public void run() {
      //  long start = System.currentTimeMillis();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(2);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // System.out.println(System.currentTimeMillis() - start);
    }
}
>>>>>>> f607f6bebd8950eb70fe88e233d2b817fdbe1d73
