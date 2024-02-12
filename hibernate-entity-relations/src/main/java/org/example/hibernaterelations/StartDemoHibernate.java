package org.example.hibernaterelations;

import org.example.hibernaterelations.entity.Note;
import org.example.hibernaterelations.entity.Person;

import javax.persistence.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;

public class StartDemoHibernate {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        Properties properties = new Properties();

        load(StartDemoHibernate.class, properties);

        emf = Persistence.createEntityManagerFactory("persistence", properties);


        //saveNewPersonWithNewNote();
//        saveNewNote();
//        addNewNote();
//        saveNewNoteUsingProxy();

        doInSession(emf, em -> {
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

    public static void load(Class<?> clazz, Properties properties) {
        try (InputStream inputStream = clazz
                .getClassLoader()
                .getResourceAsStream("hibernate.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T doInSessionReturning(EntityManagerFactory emf, Function<EntityManager, T> emFunction) {
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

    public static void doInSession(EntityManagerFactory emf, Consumer<EntityManager> emConsumer) {
        doInSessionReturning(emf, em -> {
            emConsumer.accept(em);
            return null;
        });
    }

    public static Person saveNewPersonWithNewNote(Person person, List<Note> notes, EntityManagerFactory emf) {
        return doInSessionReturning(emf, em -> {

            for (Note note : notes)
                person.addNote(note);

            em.persist(person);

            return person;
        });
    }

    private static void saveNewNote(EntityManagerFactory emf) {
        doInSession(emf, em -> {
            Person person = em.find(Person.class, 1L);
            Note note = new Note("save new note ...");
            note.setPerson(person);
            em.persist(note);
        });
    }

    private static void addNewNote(EntityManagerFactory emf) {
        doInSession(emf, em -> {
            Person person = em.find(Person.class, 1L);
            person.addNote(new Note("add new note without persist"));
        });
    }

    private static void saveNewNoteUsingProxy(EntityManagerFactory emf) {
        doInSession(emf, em -> {
            Person person = em.getReference(Person.class, 1L);
            Note note = new Note("save not used getReference");
            note.setPerson(person);
            em.persist(note);
        });
    }
}
