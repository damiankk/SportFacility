package pl.sportfacility.sportfacility.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sportfacility.sportfacility.dto.EventDto;
import pl.sportfacility.sportfacility.entity.Event;
import pl.sportfacility.sportfacility.entity.EventType;
import pl.sportfacility.sportfacility.entity.Place;
import pl.sportfacility.sportfacility.helper.EventConverter;
import pl.sportfacility.sportfacility.repository.EventRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventConverter eventConverter;

    @Autowired
    public EventServiceImpl(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.eventConverter = new EventConverter();
    }

    @Override
    public Long save(EventDto eventDto) {
        final Event event = eventConverter.converterToEntity(eventDto);
        eventRepository.save(event);

        return event.getId();
    }

    @Override
    public Long delete(Long id) {
        Event event = eventRepository.findById(id);
        eventRepository.delete(event);

        return event.getId();
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event findByTitle(String title) {
        return eventRepository.findByTitle(title);
    }

    @Override
    public Event findByDate(Date date) {
        return eventRepository.findByDate(date);
    }

    @Override
    public Event findByPlace(Place place) {
        return null;
    }

    @Override
    public Event findByEventType(EventType eventType) {
        return eventRepository.findByEventType(eventType);
    }

    @Override
    public List<EventDto> findAllEvents() {
        return eventRepository.findAll().stream() //
                .map(this::getDto) //
                .collect(Collectors.toList()); //
    }

    private EventDto getDto(final Event event){
        return eventConverter.converterToDto(event);
    }

    private Event getEntity(final EventDto eventDto){
        return eventConverter.converterToEntity(eventDto);
    }
}
