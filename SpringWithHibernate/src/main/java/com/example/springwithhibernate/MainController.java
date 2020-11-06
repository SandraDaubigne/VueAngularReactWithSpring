package com.example.springwithhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TicketService ticketservice;

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome(){

        return "Hello";

    }
    @GetMapping("/ticket")
    public void saveTicket(){
        //Anropa createticket
        //Skicka med namn och ålder
        ticketservice.createTicket("Anna", 34, 12);
    }


    //Visa alla tickets
    @GetMapping("/all")
    @ResponseBody
    public String showAllTickets(Model model){
        List<Ticket> listTickets = ticketservice.getAll();
        model.addAttribute("list", listTickets);
        return "list";
    }


}
