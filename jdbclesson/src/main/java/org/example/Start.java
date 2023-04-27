package org.example;

import org.example.dao.delegate.EntityDelegateDao;
import org.example.entity.Entity;
import org.example.provider.Provider;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

public class Start {

    public static void main(String[] args) {
 //       Provider provider = new Provider();
//        provider.setDriverManagerConnection();
//        provider.setDriverManagerFromPropsConnection();
//        provider.setHikariPoolConnection();
        EntityDelegateDao entityDelegateDao = new EntityDelegateDao();
        try {
            System.out.println(entityDelegateDao.addEntity(new Entity("entity", new HashSet<>(Arrays.asList("099-342-43","034-632-44")), new File("file.txt"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
