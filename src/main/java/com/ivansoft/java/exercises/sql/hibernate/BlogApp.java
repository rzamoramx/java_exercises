package com.ivansoft.java.exercises.sql.hibernate;

import com.ivansoft.java.exercises.sql.hibernate.models.Post;
import com.ivansoft.java.exercises.sql.hibernate.models.User;
import com.ivansoft.java.exercises.sql.hibernate.repositories.PostRepository;
import com.ivansoft.java.exercises.sql.hibernate.repositories.UserRepository;

import java.util.List;

public class BlogApp {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public BlogApp() {
        this.userRepository = new UserRepository(Client.getInstance());
        this.postRepository = new PostRepository(Client.getInstance());
    }

    public Long createPost(Long userId, String title, String content) {
        User user = userRepository.findById(userId);
        Post post = new Post();
        post.setUser(user);
        post.setTitle(title);
        post.setContent(content);
        postRepository.save(post);
        return post.getId();
    }

    public Long createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
