package pl.sportfacility.sportfacility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sportfacility.sportfacility.entity.Event;
import pl.sportfacility.sportfacility.entity.EventType;

import java.util.Date;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByTitle(final String title);

    Event findByDate(final Date date);

//    Event findByPlace(final Place place);

    Event findByEventType(final EventType eventType);

    Event findById(Long id);
}
