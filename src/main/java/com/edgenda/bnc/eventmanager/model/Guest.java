package com.edgenda.bnc.eventmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Guest {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    @NotEmpty
    private String email;

    @ManyToMany(mappedBy = "guests")
    @JsonIgnore
    private List<Event> events;

    public Guest() {
    }

    public Guest(Long id, String firstName, String lastName, String email, List<Event> events) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.events = events;
    }

    @PersistenceConstructor
    public Guest(String firstName, String lastName, String email, List<Event> events) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Event> getEvents() {
        return events;
    }

    @PreRemove
    private void removeEventsFromGuest() {
        for (Event event : events) {
            event.getGuests().remove(this);
        }
    }

}
