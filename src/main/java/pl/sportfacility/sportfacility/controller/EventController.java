package pl.sportfacility.sportfacility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sportfacility.sportfacility.dto.EventDto;
import pl.sportfacility.sportfacility.service.EventServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    private final EventServiceImpl eventService;

    @Autowired
    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @PostMapping(value = "/register")
    public HttpEntity<Long> registerNewEvent(@RequestBody final EventDto eventDto) {
        eventService.save(eventDto);

        return new ResponseEntity<Long>(HttpStatus.CREATED); //
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventDto> getEvents() {
        return eventService.findAllEvents();
    }

    @DeleteMapping(value = "/delete")
    public Long deleteEvent(@RequestBody final EventDto eventDto) {
        eventService.delete(eventDto.getId());

        return eventDto.getId();
    }
}
