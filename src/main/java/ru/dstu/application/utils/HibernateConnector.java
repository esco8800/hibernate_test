package ru.dstu.application.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateConnector {

    private static final String PERSISTENT_UNIT_NAME = "item-manager";
    public static EntityManager entityManager = getEntityManager();

    public HibernateConnector() {
    }

    public static EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME).createEntityManager();
    }
}
