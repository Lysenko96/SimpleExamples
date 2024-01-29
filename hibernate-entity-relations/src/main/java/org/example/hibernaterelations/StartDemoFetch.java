package org.example.hibernaterelations;

import org.example.hibernaterelations.entity.Person;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

import static org.example.hibernaterelations.StartDemoHibernate.saveNewPersonWithNewNote;

public class StartDemoFetch {
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        Properties properties = new Properties();

        StartDemoHibernate.load(StartDemoOneToOne.class, properties);

        emf = Persistence.createEntityManagerFactory("persistence", properties);

        saveNewPersonWithNewNote(emf);

        StartDemoHibernate.doInSession(emf, em -> {
            Person person = em.find(Person.class, 1L);
            System.out.println(person);
            // ToMany fetch now not use default FetchType.LAZY
            person.getNotes()
                    .forEach(System.out::println);
        });

    }
}
