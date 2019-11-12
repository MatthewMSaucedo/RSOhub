package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.EventRepository;
import com.RSOhub.hub.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* TODO:
 * -----------------------------------------
 * Create
 *   1) create event (CHECK)
 * -----------------------------------------
 * List
 *   1) list by location * stretch
 *   2) list by university * stretch
 *   3) list by rsos user follows
 *   4) list comments
 * -----------------------------------------
 * Comment
 *   1) add comment
 * -----------------------------------------
 * */
@RequestMapping("api/event")
@RestController
public class EventController {
    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping(path = "createEvent")
    public Event create(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @GetMapping(path = "list")
    public List<Event> listEvents() {
        return eventRepository.findAll();
    }
}
