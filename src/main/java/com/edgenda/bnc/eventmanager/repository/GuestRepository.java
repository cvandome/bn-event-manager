package com.edgenda.bnc.eventmanager.repository;

import com.edgenda.bnc.eventmanager.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    Optional<Guest> findById(Long id);

    @Query("SELECT guest FROM Guest guest JOIN guest.events event WHERE event.id = ?1")
    List<Guest> findByEventId(Long eventId);

}
