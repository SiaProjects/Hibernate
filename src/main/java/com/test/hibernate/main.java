package com.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;
import java.util.List;

public class main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(University.class)
                .buildSessionFactory();

        Session session = null;

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

//        List<Student> students = session
//                .createQuery("SELECT s FROM Student as s", Student.class)
//                .getResultList();
//
//        students.forEach(student -> System.out.println(student.getName() + " "+ student.getUniversity().getTitle()));

        University university = session.get(University.class, 1L);
        System.out.println(university);

        university.getStudents().forEach(System.out::println);

        session.getTransaction().commit();

        sessionFactory.close();

    }
}
