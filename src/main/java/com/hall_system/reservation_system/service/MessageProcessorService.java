package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.dto.ReservationDto;
import com.hall_system.reservation_system.entity.Reservations;

import java.util.LinkedHashMap;
import java.util.List;

public interface MessageProcessorService {
  List<Reservations> convertToReservations(List<LinkedHashMap>dtos);
}
