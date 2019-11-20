package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.EventRepository;
import com.RSOhub.hub.dao.RsoMembershipRepository;
import com.RSOhub.hub.dto.CreateEventRequest;
import com.RSOhub.hub.dto.ListUserEventsRequest;
import com.RSOhub.hub.model.Event;
import com.RSOhub.hub.model.Rso;
import com.RSOhub.hub.model.RsoMembership;
import com.RSOhub.hub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* TODO:
 * -----------------------------------------
 * Create
 *   1) create event (CHECK)
 * -----------------------------------------
 * List
 *   1) list by location * stretch
 *   2) list by university * stretch
 *   3) list by rsos user follows (CHECK)
 * */
@RequestMapping("api/event")
@RestController
public class EventController {
    private final EventRepository eventRepository;
    private final RsoMembershipRepository rsoMembershipRepository;

    @Autowired
    public EventController(
            EventRepository eventRepository,
            RsoMembershipRepository rsoMembershipRepository) {
        this.eventRepository = eventRepository;
        this.rsoMembershipRepository = rsoMembershipRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "create")
    public Event create(@RequestBody CreateEventRequest createEventRequest) {
        Event event = new Event(
                createEventRequest.getRefLocationId(),
                createEventRequest.getRefRsoId(),
                createEventRequest.getTime(),
                createEventRequest.getName(),
                createEventRequest.getDescription(),
                createEventRequest.getEventType()
        );
        return eventRepository.save(event);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "list")
    public List<Event> listEvents() {
        return eventRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "listUserEvents")
    public List<Event> listUserEvents(@RequestBody ListUserEventsRequest listUserEventsRequest) {
        List<RsoMembership> userRsos = rsoMembershipRepository.findByRefUserId(listUserEventsRequest.getRefUserId());
        return userRsos.stream()
                .map(rso -> rso.getRefRsoId())
                .map(eventRepository::findByRefRsoId)
                .collect(Collectors.toList());
    }
}
