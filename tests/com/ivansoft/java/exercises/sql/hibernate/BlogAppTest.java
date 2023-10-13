package com.ivansoft.java.exercises.sql.hibernate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.ivansoft.java.exercises.sql.hibernate.models.Post;
import com.ivansoft.java.exercises.sql.hibernate.models.User;
import com.ivansoft.java.exercises.sql.hibernate.repositories.PostRepository;
import com.ivansoft.java.exercises.sql.hibernate.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogAppTest {
    private BlogApp blogApp;
    private UserRepository userRepository;
    private PostRepository postRepository;

    @BeforeEach
    public void setUp() {
        Client client = Client.getInstance();
        this.blogApp = new BlogApp();
        this.userRepository = new UserRepository(client);
        this.postRepository = new PostRepository(client);
    }

    @Test
    public void testCreateUser() {
        Long userId = this.blogApp.createUser("John Doe", "john@email.com");
        User user = this.userRepository.findById(userId);
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testCreatePost() {
        Long userId = this.blogApp.createPost(1L, "First post", "This is my first post");
        Post post = this.postRepository.findById(userId);
        assertEquals("First post", post.getTitle());
    }

    @Test
    public void testGetPostsByUserId() {
        Long userId = this.blogApp.createUser("John Doe", "john@email.com");
        User user = this.userRepository.findById(userId);

        var post1 = this.blogApp.createPost(user.getId(), "First post", "This is my first post");
        var post2 = this.blogApp.createPost(user.getId(), "Second post", "This is my second post");

        System.out.println(post1);
        System.out.println(post2);

        assertEquals(2, this.blogApp.getPostsByUserId(1L).size());
    }
}
