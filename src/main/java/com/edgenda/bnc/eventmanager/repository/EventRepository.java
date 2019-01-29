package com.edgenda.bnc.eventmanager.repository;

import com.edgenda.bnc.eventmanager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findById(Long id);

    @Query("SELECT event FROM Event event JOIN event.guests guest WHERE guest.id = ?1")
    List<Event> findByGuestId(Long guestId);

}
