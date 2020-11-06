package com.example.vuewithh2.service;

import com.example.vuewithh2.entities.Post;
import com.example.vuewithh2.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
