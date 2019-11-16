package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.EventRepository;
import com.RSOhub.hub.dao.RsoMembershipRepository;
import com.RSOhub.hub.model.Event;
import com.RSOhub.hub.model.Rso;
import com.RSOhub.hub.model.RsoMembership;
import com.RSOhub.hub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "create")
    public Event create(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PostMapping(path = "list")
    public List<Event> listEvents() {
        return eventRepository.findAll();
    }

    @PostMapping(path = "listUserEvents")
    public List<Event> listUserEvents(@RequestBody User user) {
        List<RsoMembership> userRsos = rsoMembershipRepository.findByRefUserId(user.getId());
        return userRsos.stream()
                .map(rso -> rso.getRefRsoId())
                .map(eventRepository::findByRefRsoId)
                .collect(Collectors.toList());
    }
}
