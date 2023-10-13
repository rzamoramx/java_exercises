package com.ivansoft.java.exercises.sql.hibernate.repositories;

import com.ivansoft.java.exercises.sql.hibernate.Client;
import com.ivansoft.java.exercises.sql.hibernate.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserRepository {
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

    public UserRepository(Client client) {
        this.client = client;
    }

    public User findById(Long id) {
        Session session = this.client.getSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public Long save(User user) {
        Session session = this.client.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user.getId();
    }
}
