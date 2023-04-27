package org.example;

import org.example.dao.delegate.EntityDelegateDao;
import org.example.entity.Entity;
import org.example.provider.Provider;

public class Start {

    public static void main(String[] args) {
        Provider provider = new Provider();
        provider.setDriverManagerConnection();
        provider.setDriverManagerFromPropsConnection();
        provider.setHikariPoolConnection();
        EntityDelegateDao entityDelegateDao = new EntityDelegateDao();
        try {
            entityDelegateDao.addEntity(new Entity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
