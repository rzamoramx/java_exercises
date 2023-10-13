package com.ivansoft.java.exercises.sql.hibernate.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ivansoft.java.exercises.sql.hibernate.models.Post;
import java.util.List;

public class JoinsRepository {
    /*
    it is possible to use joins in hibernate, using HQL (Hibernate Query Language)
    here an example
     */

    private final SessionFactory sessionFactory;

    public JoinsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void example() {
        String hql = "SELECT p " +
                "FROM User u " +
                "JOIN u.posts p " +
                "WHERE u.id = :userId";

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        int userId = 1; // Replace with the user ID you want to query
        List<Post> posts = session.createQuery(hql, Post.class) // Post.class is for the type of the result
                .setParameter("userId", userId)
                .list();

        session.getTransaction().commit();
        session.close();
    }
}
