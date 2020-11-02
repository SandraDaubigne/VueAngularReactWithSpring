package com.example.blogg.controllers;

import com.example.blogg.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.blogg.service.PostService;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }
    @GetMapping(value = "/posts")
    public List<Post> posts(){
        return postService.getAllposts();
    }

    @PostMapping(value= "/post")
    public void publischPosts(@RequestBody Post post){
        if(post.getDateCreated() == null){
            post.setDateCreated(new Date());
        }
        postService.insert(post);
    }
}

