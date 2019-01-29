package com.edgenda.bnc.eventmanager.service;

import com.edgenda.bnc.eventmanager.model.Guest;
import com.edgenda.bnc.eventmanager.model.Event;
import com.edgenda.bnc.eventmanager.repository.GuestRepository;
import com.edgenda.bnc.eventmanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    private final GuestRepository  guestRepository;

    @Autowired
    public EventService(EventRepository eventRepository, GuestRepository guestRepository) {
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;
    }

//    public Event getEvent(Long id) {
 //       Assert.notNull(id, "Event ID cannot be null");
  //      return eventRepository.findById(id);
  //  }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public List<Guest> getGuestsWithEvents(Long eventId) {
        Assert.notNull(eventId, "Event ID cannot be null");
        return guestRepository.findByEventId(eventId);
    }
}

