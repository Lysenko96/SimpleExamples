package LessonsToInterview.CloneTest;

import java.util.GregorianCalendar;

public class MainCloneTest {
    Person personAnastasiaOriginal = new Person("Anastasia",22);
    //Person personAnastasiaOriginal1 = new Gamer("Anton");
    Person personAnastasiaCopy = personAnastasiaOriginal;

    private MainCloneTest(){
        //personAnastasiaCopy = personAnastasiaOriginal1;
         System.out.println(personAnastasiaOriginal.getNamePerson());
         try {
             personAnastasiaCopy = personAnastasiaOriginal.clone();
             //personAnastasiaCopy.setAgePerson(18);
         } catch (CloneNotSupportedException e) {
             e.printStackTrace();
         }

         personAnastasiaCopy.setNamePerson("Ivan");
         System.out.println(personAnastasiaOriginal.getNamePerson());
         //System.out.println(personAnastasiaCopy.getAgePerson());
        //System.out.println(personAnastasiaOriginal.getAgePerson());
    }
    public static void main(String[] args) {
        new MainCloneTest();
    }

 
}
class Person implements Cloneable{
    Person(){

    }
    private Gamer gamer;
    Person(String name, int age){
        this.namePerson = name;
        this.agePerson = age;
       // gamer = new Gamer();
        //this.gamer.setNamePerson(gamer.getNamePerson());
    }
    private String namePerson = "";
    private int agePerson = 0;
    public String getNamePerson(){ return namePerson; }
    public void setNamePerson(String name){ this.namePerson = name; }
    public int getAgePerson(){ return agePerson; }
    public void setAgePerson(int age){ this.agePerson = age; }
/*    public Gamer getAccessGamer(Gamer gamer){
        return  null;
    }*/

    @Override
    public Person clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        //cloned.gamer = (Gamer) gamer.clone();
        return cloned;
    }
}
class Gamer extends Person{
    private String nameGamer = "";
    Gamer(){

    }
    Gamer(String name){
        this.nameGamer = name;
    }
    @Override
    public String getNamePerson() {
        return nameGamer;
    }
    @Override
    public void setNamePerson(String name) {
        this.nameGamer = name;
    }
}