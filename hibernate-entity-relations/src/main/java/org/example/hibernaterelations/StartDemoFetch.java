package org.example.hibernaterelations;

import org.example.hibernaterelations.entity.Note;
import org.example.hibernaterelations.entity.Person;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.example.hibernaterelations.StartDemoHibernate.saveNewPersonWithNewNote;

public class StartDemoFetch {
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        Properties properties = new Properties();

        StartDemoHibernate.load(StartDemoOneToOne.class, properties);

        emf = Persistence.createEntityManagerFactory("persistence", properties);

        Person person = new Person();
        person.setFirstName("Oksana");
        person.setLastName("best");
        person.setEmail("bestoksanamail@gmail.com");

        Note note = new Note("study processing...");

        Person person1 = new Person();
        person1.setFirstName("Jackie");
        person1.setLastName("best");
        person1.setEmail("bestjackiemail@gmail.com");

        Note note1 = new Note("my note1 processing...");
        Note note2 = new Note("my second note2 processing...");

        saveNewPersonWithNewNote(person, List.of(note), emf);
        saveNewPersonWithNewNote(person1, List.of(note1, note2), emf);

        StartDemoHibernate.doInSession(emf, em -> {
            //List<Person> persons = em.createQuery("SELECT DISTINCT p FROM Person p JOIN FETCH p.notes", Person.class)
            List<Person> persons = em.createQuery("SELECT DISTINCT p FROM Person p WHERE p.id > 1", Person.class) // fetch = FetchType.EAGER have n + 1 select problem
                    .getResultList();

            for (Person p : persons) {
                if(!p.getNotes().isEmpty()) {
                    System.out.println("person " + p.getFirstName() + " " + p.getLastName() + " have notes: " + p.getNotes());
                }
            }


        });

//        StartDemoHibernate.doInSession(emf, em -> {
//            Person person = em.find(Person.class, 1L);
//            System.out.println(person);
//            // ToMany fetch now not use default FetchType.LAZY
//            person.getNotes()
//                    .forEach(System.out::println);
//        });

    }
}
