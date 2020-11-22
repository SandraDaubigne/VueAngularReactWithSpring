package com.example.angular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    //Hämta alla objekt
    //Skapa en metod som hämtar ett en lista av objekt och returnerar
    //dem som JSON genom restcontroller

    @CrossOrigin
    @GetMapping("/all")
    public List<Topic> topics(){
        return topicService.getAllTopics();
    }


    /*
    //Endpoint for create a topic
    @GetMapping("/create")
    public String createTopic(){
        topicService.createTopic("Blogg 1", "This is blogg 1");
        topicService.createTopic("Blogg 2", "This is blogg 2");
        topicService.createTopic("Blogg 3", "This is blogg 3");
        return "redirect:all";
    }

    //Endpoint for get all topics
    @GetMapping("all")
    public String seeAllTopics(Model model){
        List<Topic> topics = topicService.getAllTopics();
        model.addAttribute("topics" , topics);
        return "index";
    }*/
}