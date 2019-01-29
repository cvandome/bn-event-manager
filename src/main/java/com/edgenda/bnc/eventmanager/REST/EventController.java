package com.edgenda.bnc.eventmanager.rest;

import com.edgenda.bnc.eventmanager.model.Guest;
import com.edgenda.bnc.eventmanager.model.Event;
import com.edgenda.bnc.eventmanager.service.EventService;
//import com.edgenda.bnc.eventmanager.service.exception.UnknownEventException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

  //  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
   // public ResponseEntity<?> getEvent(@PathVariable Long id) {
     //   try {
      //      return new ResponseEntity<>(eventService.getEvent(id), HttpStatus.OK);
     //   } catch (UnknownEventException e) {
      //      return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
     //   }
   // }

    @RequestMapping(path = "/{id}/guests", method = RequestMethod.GET)
    public List<Guest> getGuestsWithEvents(@PathVariable Long id) {
        return eventService.getGuestsWithEvents(id);
    }
}