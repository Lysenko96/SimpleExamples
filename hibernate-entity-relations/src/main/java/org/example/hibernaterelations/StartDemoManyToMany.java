package org.example.hibernaterelations;

import org.example.hibernaterelations.entity.Employee;
import org.example.hibernaterelations.entity.Guild;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class StartDemoManyToMany {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        Properties properties = new Properties();

        StartDemoHibernate.load(StartDemoOneToOne.class, properties);

        emf = Persistence.createEntityManagerFactory("persistence", properties);

        StartDemoHibernate.doInSession(emf, em -> {
            Employee employee = new Employee("Alex", "Canada");
            Guild guild = new Guild("apex");
            Guild guild1 = new Guild("liquid");
            guild.addEmployee(employee);
            Employee employee1 = new Employee("Jackie", "Chan");
            guild.addEmployee(employee1);
            guild1.addEmployee(employee);
            em.persist(guild);
            em.persist(guild1);

            Guild myGuild = em.find(Guild.class, 1L);
            // Jackie no employee id, because guilds add employee after em.persist(guild)
//            Employee employee2 = new Employee("Jackie", "Chan");
//            guild.addEmployee(employee2);
            System.out.println(myGuild);
        });
    }
}
