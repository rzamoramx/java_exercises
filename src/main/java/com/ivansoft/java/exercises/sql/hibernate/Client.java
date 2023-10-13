package com.ivansoft.java.exercises.sql.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {
    private static final Client INSTANCE = new Client();
    private final SessionFactory sessionFactory;

    private Client() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Client getInstance() {
        return INSTANCE;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
