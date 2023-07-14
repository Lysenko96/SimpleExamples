package org.example.jparelations;

import org.example.jparelations.config.Config;
import org.example.jparelations.entity.Husband;
import org.example.jparelations.entity.Student;
import org.example.jparelations.entity.Teacher;
import org.example.jparelations.entity.Wife;
import org.example.jparelations.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PersonService personService = context.getBean("personService", PersonService.class);

        Wife wife = new Wife("namewife", "surnamewife", "234252", "email3", "job3");
       // Wife wife2 = new Wife("namewife", "surnamewife", "234252", "email3", "job3");
       // Husband husband = new Husband("name", "surname", "234251", "email", "job", wife);
        Husband husband = new Husband("name", "surname", "234251", "email", "job", wife);
       // Husband husband2 = new Husband("name", "surname", "234251", "email", "job", wife2);
       // personService.saveWife(wife);
        personService.saveHusband(husband);
        //personService.saveHusband(husband2);
        //husband.setWife(wife);
        Husband husbandDb = personService.findHusbandById(1L);
        System.out.println(husbandDb);
        System.out.println(husbandDb.getWife());
        System.out.println(husbandDb.getWife().getHusband());


        //personService.deleteWife(wife);
//        personService.deleteHusband(husband);

//        Wife wifeDb = personService.findWifeById(1L);
//        System.out.println(wifeDb);
//        System.out.println(wifeDb.getHusband());
//        System.out.println(wifeDb.getHusband().getWife());

        Student student = new Student("studentname", "studentlastname", "52352", "email", "master");
        Student student2 = new Student("studentname2", "studentlastname2", "52353", "email2", "master");
        Student student3 = new Student("studentname3", "studentlastname3", "52355", "email3", "master");
        List<Student> students = Arrays.asList(student2, student);
        List<Student> students2 = Arrays.asList(student3);
        Teacher teacher = new Teacher("name", "lastname", "22352", "email@gmail.com", "programming", students);
        Teacher teacher2 = new Teacher("name2", "lastname2", "22351", "email1@gmail.com", "programming", students2);

        personService.saveTeacher(teacher);
        //personService.saveStudent(student);
        //personService.saveTeacher(teacher2);

        Teacher teacherDb = personService.findTeacherById(1L);
        System.out.println(teacherDb.getStudents());
       System.out.println(teacherDb.getStudents().get(0));
        System.out.println(teacherDb.getStudents().get(0).getTeacher());

        //  Husband husbandDb = personService.findHusbandById(1L);
//        personService.deleteHusbandById(1L);
//        System.out.println(husbandDb);
//        System.out.println(husbandDb.getWife());
//        System.out.println(husbandDb.getWife().getHusband());

        //personService.deleteHusbandById(1L);
        //personService.deleteWifeById(1L);


    }
}
