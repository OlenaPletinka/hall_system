package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.entity.Hall;
import com.hall_system.reservation_system.entity.Seats;

public interface SeatsService {
  Seats findSeatsBySeatsNumberAndHall(Integer number, Hall hall);
}
