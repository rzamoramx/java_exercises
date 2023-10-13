package com.ivansoft.java.exercises.sql.hibernate;

import com.ivansoft.java.exercises.sql.hibernate.models.Post;
import com.ivansoft.java.exercises.sql.hibernate.BlogApp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BlogApp blogApp = new BlogApp();

        var user1 = blogApp.createUser("John Doe", "email@emial.com");
        var user2 = blogApp.createUser("Jane Doe", "jane@email.com");

        blogApp.createPost(user1, "First post", "This is my first post");
        blogApp.createPost(user1, "Second post", "This is my second post");
        blogApp.createPost(user2, "Third post", "This is my third post");

        List<Post> posts = blogApp.getPostsByUserId(user1);
        for (Post post : posts) {
            System.out.println(post.getTitle());
        }
    }
}
