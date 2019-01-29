package com.edgenda.bnc.eventmanager.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String eventDate;

    @NotEmpty
    private String description;

    @ManyToMany
    @JoinTable(name = "GUESTS_EVENTS")
    private List<Guest> guests;

    public Event() {
    }

    public Event(Long id, String eventDate, String description, List<Guest> guests) {
        this.id = id;
        this.eventDate = eventDate;
        this.description = description;
        this.guests = guests;
    }

    @PersistenceConstructor
    public Event(String eventDate, String description, List<Guest> guests) {
        this.eventDate = eventDate;
        this.description = description;
        this.guests = guests;
    }

    public Long getId() {
        return id;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getDescription() {
        return description;
    }

    public List<Guest> getGuests() {
        return guests;
    }
}
