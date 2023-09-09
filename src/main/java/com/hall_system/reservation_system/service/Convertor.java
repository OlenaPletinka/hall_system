package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.dto.ReservationDto;
import com.hall_system.reservation_system.entity.Reservations;

import java.util.LinkedHashMap;
import java.util.List;

public interface Convertor {
  List<Reservations> convertDtoToReservations(List<ReservationDto> dtos);
  Reservations convertMessageDtoToReservations(LinkedHashMap<String, Object>dto);
}
