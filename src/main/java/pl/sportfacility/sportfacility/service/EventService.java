package pl.sportfacility.sportfacility.service;

import pl.sportfacility.sportfacility.dto.EventDto;
import pl.sportfacility.sportfacility.entity.Event;
import pl.sportfacility.sportfacility.entity.EventType;
import pl.sportfacility.sportfacility.entity.Place;

import java.util.Date;
import java.util.List;

public interface EventService {

    Long save(final EventDto event) throws ClassNotFoundException;

    Long delete(final Long id);

    Event findById(final Long id);

    Event findByTitle(final String title);

    Event findByDate(final Date date);

    Event findByPlace(final Place place);

    Event findByEventType(final EventType eventType);

    List<EventDto> findAllEvents();
}
