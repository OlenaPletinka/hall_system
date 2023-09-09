package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.entity.Reservations;
import com.hall_system.reservation_system.repository.ReservationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsServiceImpl implements ReservationService{
  private static final Logger LOGGER = LoggerFactory.getLogger(ReservationsServiceImpl.class);
  private final ReservationsRepository reservationsRepository;

  @Autowired
  public ReservationsServiceImpl(ReservationsRepository reservationsRepository) {
    this.reservationsRepository = reservationsRepository;
  }

  @Override
  public void createReservations(List<Reservations> reservations) {
    reservationsRepository.saveAll(reservations);
    LOGGER.info(String.format("%d - Reserervations was created successfully", reservations.size()));

  }
}
