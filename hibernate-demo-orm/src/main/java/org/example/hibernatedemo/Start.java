package org.example.hibernatedemo;

import org.example.hibernatedemo.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.QueryHints;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;

public class Start {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        Properties properties = new Properties();

        load(properties);
//        Person newPerson = new Person();
//        newPerson.setFirstName("Anton");
//        newPerson.setLastName("Lysenko");
//        newPerson.setEmail("lysenko@gmail3.com");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence", properties);
//        System.out.println(emf);

//
        EntityManager em0 = emf.createEntityManager();
        //em0.unwrap(Session.class).setDefaultReadOnly(true); // off "dirty checking" update orm on find example entity
        em0.setFlushMode(FlushModeType.AUTO); // default
        EntityTransaction tx = em0.getTransaction();
        tx.begin();
        // em0.persist(newPerson);
        // Person person = em0.find(Person.class, 1L);
        //em0.remove(person);
//        em0.persist(newPerson);
//        em0.remove(newPerson);
//        em0.persist(newPerson);
//        person.setLastName("Alexenko"); // dirty checking

        Person newPerson = new Person();
        newPerson.setFirstName("Anton12");
        newPerson.setLastName("Lysenko412");
        newPerson.setEmail("lysenko@gmail412.com");
        em0.persist(newPerson);

        // changes sent to the DB
       // em0.flush();

        em0.createQuery("SELECT p FROM Person p", Person.class)
                .getResultStream()
                .forEach(System.out::println);

        tx.commit();
        em0.close();
//
//        EntityManager em1 = emf.createEntityManager();
//        EntityTransaction tx1 = em1.getTransaction();
//        tx1.begin();
//        Person mergedPerson = em1.merge(person);
//        em1.remove(mergedPerson);
//        tx1.commit();
//        em1.close();

        //Person person;
        try (SessionFactory sessionFactory = getSessionFactory(config, properties)) {

//            EntityManager em1 = sessionFactory.createEntityManager();
//            EntityTransaction tx1 = em1.getTransaction();
//            tx1.begin();

//            em1.persist(newPerson);
//            tx1.commit();
//            em1.close();

            // doInSession(sessionFactory, em -> em.persist(newPerson));

//            Person person = doInSessionReturning(sessionFactory, em -> em.find(Person.class, 1L));
//            System.out.println(person);

//            doInSession(sessionFactory, em -> {
//                Person samePerson = em.find(Person.class, 1L);
//                Person person1 = em.createQuery("FROM Person p WHERE p.id =: id", Person.class)
//                        .setParameter("id", 1L)
//                        .getSingleResult();
//                System.out.println(samePerson);
//                System.out.println(person1);
//                System.out.println(samePerson==person1);
//                em.remove(person1);
//            });
//            doInSession(sessionFactory, em -> {
//                Person mergedPerson1 = em.merge(newPerson);
//                em.persist(mergedPerson1);
//            });
//            person = doInSessionReturning(sessionFactory, em -> em.find(Person.class, 1L));
//            Person person = doInSessionReturning(sessionFactory, em -> em.find(Person.class, 1L));
//            doInSession(sessionFactory, em ->  em.remove(person));


//            Person p1 = doInSessionReturning(sessionFactory, em -> em.find(Person.class, 1L));
//            Person p2 = doInSessionReturning(sessionFactory, em -> em.find(Person.class, 1L));
//            System.out.println(p1==p2);


//            Session session = sessionFactory.openSession();

//            Session session1 = sessionFactory.getCurrentSession();
//            session1.beginTransaction();

//            EntityManagerFactory emf = session.getEntityManagerFactory();
//            EntityManagerFactory emf1 = session1.getEntityManagerFactory();

//            EntityManager em = emf.createEntityManager();
//            EntityManager em1 = emf1.createEntityManager();


            //Transaction tx = session.beginTransaction();

//            Person person = em.createQuery("FROM Person p WHERE p.id =: id", Person.class)
//                    .setParameter("id", 1L)
//                    .getSingleResult();
//            Person person1 = em1.createQuery("FROM Person p WHERE p.id =: id", Person.class)
//                    .setParameter("id", 1L)
//                    .getSingleResult();
            // tx.commit();


            // person.setLastName("unknown");

            //em.remove(person);

        }
//        try (SessionFactory sessionFactory1 = getSessionFactory(config, properties)) {
//            doInSession(sessionFactory1, em -> em.remove(person));
//        }
    }

    private static SessionFactory getSessionFactory(Configuration config, Properties properties) {
        config.setProperties(properties);
        config.addAnnotatedClass(Person.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        return config.buildSessionFactory(serviceRegistry);
    }

    private static void load(Properties properties) {
        try (InputStream inputStream = Start.class
                .getClassLoader()
                .getResourceAsStream("hibernate.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doInSession(SessionFactory sessionFactory, Consumer<EntityManager> entityManagerConsumer) {
        doInSessionReturning(sessionFactory, entityManager -> {
            entityManagerConsumer.accept(entityManager);
            return null;
        });
    }

    private static <T> T doInSessionReturning(SessionFactory sessionFactory, Function<EntityManager, T> entityManagerFunction) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = sessionFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            T result = entityManagerFunction.apply(em);
            tx.commit();
            return result;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (em != null) em.close();
        }
    }
}
