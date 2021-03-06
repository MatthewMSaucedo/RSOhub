package com.RSOhub.hub.dao;

import com.RSOhub.hub.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findByRefRsoId(int refRsoId);
}