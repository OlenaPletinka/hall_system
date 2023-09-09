package com.hall_system.reservation_system.repository;

import com.hall_system.reservation_system.entity.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface EventRepository extends CrudRepository<Event, Long> {
  Event findByNameAndTime(String name, LocalDateTime time);
}
