package com.test.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().buildSessionFactory();

        sessionFactory.close();

    }
}
