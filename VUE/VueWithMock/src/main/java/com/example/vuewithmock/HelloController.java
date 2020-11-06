package com.example.vuewithmock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    private List<Topic> topics = Arrays.asList(
            new Topic("Bake a kake", "Do this"),
            new Topic("Bake a cookie", "Do this"),
            new Topic("Make some food", "Do this"));

    @GetMapping("/")
    public String getAllTopics(Model model){
        model.addAttribute("topics", topics);
        return "index";
    }

}
