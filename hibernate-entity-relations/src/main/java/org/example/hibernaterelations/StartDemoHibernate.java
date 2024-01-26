package org.example.hibernaterelations;

import org.example.hibernaterelations.entity.Note;
import org.example.hibernaterelations.entity.Person;

import javax.persistence.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;

public class StartDemoHibernate {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        Properties properties = new Properties();

        load(properties);

        emf = Persistence.createEntityManagerFactory("persistence", properties);


        doInSession(em -> {
//            Person person = new Person();
//            person.setFirstName("bender");
//            person.setLastName("futurama");
//            person.setEmail("kissmyassbender@gmail.com");

            //Person person = em.find(Person.class, 1L);

            //add note dirty checking and update without persists
         //   Note note = new Note("add note dirty checking and update without persists");
           // note.setPerson(person);
          //  person.getNotes().add(note);
            //em.persist(person); //


//            em.persist(note);

//            Note newNote = new Note("my unknown new note");
//            em.persist(newNote);



//            person.getNotes().add(newNote); // don't add note to person
//            newNote.setPerson(theSamePerson); // right because mappedBy = "person"

//            Note note = em.find(Note.class, 1L);
//            System.out.println(note);
        });


//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        tx.begin();
//
//
//        tx.commit();
//
//        em.close();
    }

    private static void load(Properties properties) {
        try (InputStream inputStream = StartDemoHibernate.class
                .getClassLoader()
                .getResourceAsStream("hibernate.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> T doInSessionReturning(Function<EntityManager, T> emFunction) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T result = emFunction.apply(em);
            tx.commit();
            return result;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    private static void doInSession(Consumer<EntityManager> emConsumer) {
        doInSessionReturning(em -> {
            emConsumer.accept(em);
            return null;
        });
    }
}
