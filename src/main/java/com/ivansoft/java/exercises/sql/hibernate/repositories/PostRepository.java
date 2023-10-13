package com.ivansoft.java.exercises.sql.hibernate.repositories;

import com.ivansoft.java.exercises.sql.hibernate.Client;
import com.ivansoft.java.exercises.sql.hibernate.models.Post;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.List;

public class PostRepository {
    /*
    Note: for close sessions

    *** Session-Per-Operation (Short-Lived Sessions):

    In this approach, you open a new session for each database operation and close it immediately after the operation
    is completed. This is a common practice in web applications where each HTTP request corresponds to a short-lived
    session. This pattern is suitable for most web applications and straightforward use cases.

    Pros:
    Reduces the risk of resource leaks and associated problems.
    Keeps sessions and database connections short-lived, which can be more efficient.

    Cons:
    Incur some overhead in session creation and destruction, which can be negligible in most applications

    *** Long-Lived Session (Extended Sessions):

    In some scenarios, especially in desktop applications or long-running background tasks, you may keep the Hibernate
    session open for an extended period. This approach allows you to maintain a session across multiple database
    operations. However, you should be cautious when using this approach because it can lead to issues like stale data,
    increased resource consumption, and potential data consistency problems.

    Pros:
    Reduces the overhead of session creation and destruction.
    Suitable for long-running applications or background tasks.

    Cons:
    Increased risk of data inconsistencies.
    May consume more resources, including database connections.
     */
    private final Client client;

    public PostRepository(Client client) {
        this.client = client;
    }

    public Long save(Post post) {
        Session session = client.getSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
        session.close();
        return post.getId();
    }

    public Post findById(Long id) {
        Session session = client.getSession();
        Post post = session.get(Post.class, id);
        session.close();
        return post;
    }

    public List<Post> findByUserId(Long userId) {
        Session session = client.getSession();
        List<Post> posts = session.createQuery("from Post where user_id = :userId", Post.class)
            .setParameter("userId", userId)
            .getResultList();
        session.close();
        return posts;
    }
}
