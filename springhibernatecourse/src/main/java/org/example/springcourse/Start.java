package org.example.springcourse;

import org.example.springcourse.config.HibernateConfig;
import org.example.springcourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        try (SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class)) {
            System.out.println(sessionFactory);
            Session session = sessionFactory.getCurrentSession();
            Person person = new Person("Ivan", "Pupkin", 2000, "9379992", "Sverstuka 17", "vanyapupkin111@gmail.com");
            Person person2 = new Person("Petya", "Petrov", 2001, "9379991", "Sverstuka 15", "petyapetrov111@gmail.com");
            session.beginTransaction();
            //  System.out.println(person);

            // save
            session.persist(person);
            session.persist(person2);

            session.getTransaction().commit();
            // System.out.println(person);
            session.close();


            Session session1 = sessionFactory.getCurrentSession();
            session1.beginTransaction();
            System.out.println(session1.find(Person.class, person.getId()));
            session1.getTransaction().commit();
            session1.close();

            Session session2 = sessionFactory.getCurrentSession();
            session2.beginTransaction();

            // update
            session2.createMutationQuery("update Person set secondName = :secondName where firstName = :firstName")
                    .setParameter("secondName", "test")
                    .setParameter("firstName", "Petya")
                    .executeUpdate();

            // select
            List<Person> persons = session2.createQuery("from Person", Person.class).getResultList();
            List<Person> personsWhereNameIvan = session2.createQuery("from Person where firstName = :firstName", Person.class)
                    .setParameter("firstName", "Ivan")
                    .getResultList();

            // update ORM
            Person person1 = session2.get(Person.class, person.getId());
            person1.setPhone("111333555");

            session2.getTransaction().commit();
            session2.close();

            Session session3 = sessionFactory.getCurrentSession();
            session3.beginTransaction();

            Person person3 = session3.get(Person.class, person.getId());
            session3.remove(person3);

            List<Person> personList = session3.createSelectionQuery("from Person", Person.class)
                            .list();

            session3.getTransaction().commit();

            System.out.println(person2);

            System.out.println(personsWhereNameIvan);

            System.out.println(personList);

        }

    }
}
