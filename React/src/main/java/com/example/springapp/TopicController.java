package com.example.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    /*****************GET REQUESTS*********************/
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
       return topicService.getAllTopics();

    }

    //Tala om att det är en variablepath så gör man {id}
    //För att inte förväxla med URL
    //Man måste också visa att det är en variabel genom att sätta @Pathvariable
    //Detta funkar nu för att {id} och String id har samma namn

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    /*****************POST REQUESTS*********************/

    //Post body kommer innehålla objektet i sig självt
    //En ny topic som sänds in
    //Denna metoden kommer anropas när en post request är skickad
    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        //@RequestBody Topic topic - Get the request body and pass it to me as an topic instance
        //Take that request body and convert it into a topic instance
        //Vi skickade JSON som en requestbody och fick ett nytt objekt
        topicService.addTopic(topic);
    }

    /*****************PUT REQUESTS*********************/

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    /*****************DELETE REQUESTS*********************/

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic( @PathVariable String id){
        topicService.deleteTopic(id);
    }




















}
