package com.edgenda.bnc.eventmanager.rest;

import com.edgenda.bnc.eventmanager.model.Guest;
import com.edgenda.bnc.eventmanager.model.Event;
import com.edgenda.bnc.eventmanager.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    public Guest getGuest(@PathVariable Long id) {
//        return guestService.getGuest(id);
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Guest> getAllGuests() {
        return guestService.getGuests();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.createGuest(guest);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        guestService.updateGuest(
                new Guest(
                        id,
                        guest.getFirstName(),
                        guest.getLastName(),
                        guest.getEmail(),
                        guest.getEvents()
                )
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
    public Guest patchGuest(@PathVariable Long id, @RequestBody Guest guest) {
        guestService.deleteGuest(id);
        return guestService.createGuest(guest);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
    }

    @RequestMapping(path = "/{id}/events", method = RequestMethod.GET)
    public List<Event> getGuestEvents(@PathVariable Long id) {
        return guestService.getGuestEvents(id);
    }

}