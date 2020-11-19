package com.example.react;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    //Create a topic
    public Topic createTopic(String title, String description){
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setDescription(description);

        return topicRepository.save(topic);
    }

    //Get all topics
    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll().forEach(topics ::add);
        return topics;
    }
}
