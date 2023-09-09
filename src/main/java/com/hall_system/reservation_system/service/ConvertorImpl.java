package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.dto.ReservationDto;
import com.hall_system.reservation_system.entity.Event;
import com.hall_system.reservation_system.entity.Reservations;
import com.hall_system.reservation_system.entity.Seats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ConvertorImpl implements  Convertor{
  private final EventService eventService;
  private final SeatsService seatsService;

  @Autowired
  public ConvertorImpl(EventService eventService, SeatsService seatsService) {
    this.eventService = eventService;
    this.seatsService = seatsService;
  }

  @Override
  public List<Reservations> convertDtoToReservations(List<ReservationDto> dtos) {
    List<Reservations>reservationsList = new ArrayList<>();
    for (ReservationDto dto: dtos){
      Reservations reservations = new Reservations();
      reservations.setReservedBy(dto.getReservedBy());
      Event event = eventService.findByEventNameAndTime(dto.getEventName(), dto.getEventTime());
      reservations.setEvent(event);
      reservations.setSeats(seatsService.findSeatsBySeatsNumberAndHall(dto.getSeatsNumber(), event.getHall()));
      reservationsList.add(reservations);
    }
    return reservationsList;
  }

  @Override
  public Reservations convertMessageDtoToReservations(LinkedHashMap<String, Object> dto) {
    Reservations reservation = new Reservations();
    String eventName = (String) dto.get("eventName");
    List<Integer> list = (List<Integer>) dto.get("eventTime");
    LocalDateTime eventTime = LocalDateTime.of(list.get(0), list.get(1), list.get(2), list.get(3),
              list.get(4));
    Event event = eventService.findByEventNameAndTime(eventName, eventTime);
    reservation.setEvent(event);
    Seats seats = seatsService.findSeatsBySeatsNumberAndHall((Integer) dto.get("seatsNumber"), event.getHall());
    reservation.setSeats(seats);
    reservation.setReservedBy((String) dto.get("reservedBy"));

    return reservation;
  }
}
