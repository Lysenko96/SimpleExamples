package org.example.hibernatedemo;

import org.example.hibernatedemo.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Start {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        Properties properties = new Properties();
        try (InputStream inputStream = Start.class
                .getClassLoader()
                .getResourceAsStream("hibernate.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setProperties(properties);
        config.addAnnotatedClass(Person.class);


        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();

        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        EntityManagerFactory emf = session.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Transaction tx = session.beginTransaction();
        Person newPerson = new Person();
        newPerson.setFirstName("Anton");
        newPerson.setLastName("Lysenko");
        em.persist(newPerson);
        em.getTransaction().commit();
        Person person = em.createQuery("FROM Person p WHERE p.id =: id", Person.class)
                .setParameter("id", 1L)
                .getSingleResult();
        // tx.commit();

        //Person person = em.find(Person.class, 3459L);


        //Person person = em.find(Person.class, 1L);
        System.out.println(person);
        person.setLastName("unknown");
        //em.remove(person);
       // em.getTransaction().commit();

        emf.close();
        em.close();
        session.close();
        sessionFactory.close();

    }
}
