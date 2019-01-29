package com.edgenda.bnc.eventmanager.service;

import com.edgenda.bnc.eventmanager.model.Guest;
import com.edgenda.bnc.eventmanager.model.Event;
import com.edgenda.bnc.eventmanager.repository.GuestRepository;
import com.edgenda.bnc.eventmanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class GuestService {

    private final GuestRepository guestRepository;

    private final EventRepository eventRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository, EventRepository eventRepository) {
        this.guestRepository = guestRepository;
        this.eventRepository = eventRepository;
    }

 //   public Guest getGuest(Long id) {
  //      Assert.notNull(id, "Guest ID cannot be null");
   //     return guestRepository.findById(id);
   // }

    public List<Guest> getGuests() {
        return guestRepository.findAll();
    }

    public Guest createGuest(Guest guest) {
        Assert.notNull(guest, "Guest cannot be null");
        final Guest  newGuest = new Guest(
                guest.getFirstName(),
                guest.getLastName(),
                guest.getEmail(),
                Collections.emptyList()
        );
        return guestRepository.save(newGuest);
    }

    public void updateGuest(Guest guest) {
        Assert.notNull(guest, "Employee cannot be null");
 //       this.getGuest(guest.getId());
        guestRepository.save(guest);
    }

    public List<Event> getGuestEvents(Long guestId) {
        return eventRepository.findByGuestId(guestId);
    }

    public void deleteGuest(Long id) {
        Assert.notNull(id, "ID cannot be null");
        guestRepository.delete(id);
    }
}
