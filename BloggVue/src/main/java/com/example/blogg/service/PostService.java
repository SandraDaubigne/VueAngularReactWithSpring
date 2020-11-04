package com.example.blogg.service;

import com.example.blogg.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.blogg.repositories.PostRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllposts(){

        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }
}
