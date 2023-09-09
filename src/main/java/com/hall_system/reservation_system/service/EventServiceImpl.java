package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.entity.Event;
import com.hall_system.reservation_system.entity.Hall;
import com.hall_system.reservation_system.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventServiceImpl implements EventService{
  private final EventRepository eventRepository;

  @Autowired
  public EventServiceImpl(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }


  public Event findByEventNameAndTime(String eventName, LocalDateTime eventTime) {
    return eventRepository.findByNameAndTime(eventName, eventTime);
  }
}
