package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.entity.Event;
import com.hall_system.reservation_system.entity.Hall;

import java.time.LocalDateTime;

public interface EventService {
  Event findByEventNameAndTime(String eventName, LocalDateTime eventTime);
}
