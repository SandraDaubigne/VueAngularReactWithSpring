package com.example.springwithhibernate;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository  extends CrudRepository<Ticket, Integer> {
}