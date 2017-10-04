package pl.sportfacility.sportfacility.service;


import pl.sportfacility.sportfacility.entity.Ticket;

public interface TicketService {

    Ticket findbyId(Long id);
}
