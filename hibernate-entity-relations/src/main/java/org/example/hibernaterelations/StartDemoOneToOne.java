package org.example.hibernaterelations;

import org.example.hibernaterelations.entity.Address;
import org.example.hibernaterelations.entity.Profile;
import org.example.hibernaterelations.entity.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class StartDemoOneToOne {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        Properties properties = new Properties();

        StartDemoHibernate.load(StartDemoOneToOne.class, properties);

        StartDemoOneToOne.emf = Persistence.createEntityManagerFactory("persistence", properties);


    StartDemoHibernate.doInSession(emf, em -> {
        User user = new User("eee_boooy");
        Address address = new Address();
        address.setCity("Novogrodovka");
        address.setStreet("Tyhaja 9");
        user.setAddress(address);
        em.persist(user);
    });


        StartDemoHibernate.doInSession(emf, em -> {
            Profile profile = new Profile();
            profile.setPhotoUrl("http://photo_url");
            profile.setActive(true);
            User user = em.find(User.class, 1L);
            user.setProfile(profile);
        });



        StartDemoHibernate.doInSession(emf, em -> {
            User user = em.find(User.class, 1L);
            System.out.println(user);
            // ToOne fetch now default FetchType.EAGER
            System.out.println(user.getAddress());
            System.out.println(user.getProfile());
        });

    }

}
