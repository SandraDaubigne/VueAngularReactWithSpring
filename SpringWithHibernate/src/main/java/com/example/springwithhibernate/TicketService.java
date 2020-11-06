package com.example.springwithhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    //Skapa en biljett
    public Ticket createTicket(String text, int price, int age){
        Ticket ticket = new Ticket();
        ticket.setName(text);
        ticket.setPrice(price);
        ticket.setAge(age);

        return ticketRepository.save(ticket);
    }

    //Hämta alla biljetter
    public List<Ticket> getAll(){
        List<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;

    }

}