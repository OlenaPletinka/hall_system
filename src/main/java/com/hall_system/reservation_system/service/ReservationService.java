package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.entity.Reservations;

import java.util.List;

public interface ReservationService {
  void createReservations(List<Reservations>reservations);
}
