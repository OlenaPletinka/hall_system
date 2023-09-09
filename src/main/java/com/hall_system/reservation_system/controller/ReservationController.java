package com.hall_system.reservation_system.controller;

import com.hall_system.reservation_system.dto.ReservationDto;
import com.hall_system.reservation_system.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "reservation")
public class ReservationController {
  private final ReservationService reservationService;

  @Autowired
  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<String> createReservations(@RequestBody List<ReservationDto> dtos){
    reservationService.createReservationsFromDtoList(dtos);
    return ResponseEntity.ok(String.format("%d reservations was created.", dtos.size()));
  }
}
