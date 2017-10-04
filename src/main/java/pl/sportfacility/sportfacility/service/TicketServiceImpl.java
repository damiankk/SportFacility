package pl.sportfacility.sportfacility.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sportfacility.sportfacility.entity.Ticket;
import pl.sportfacility.sportfacility.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket findbyId(Long id) {
        return null;
    }
}
