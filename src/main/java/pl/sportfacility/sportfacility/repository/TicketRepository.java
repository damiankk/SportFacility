package pl.sportfacility.sportfacility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sportfacility.sportfacility.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

    Ticket findById(final Long id);
}
