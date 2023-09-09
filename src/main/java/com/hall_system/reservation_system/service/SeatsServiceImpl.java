package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.entity.Hall;
import com.hall_system.reservation_system.entity.Seats;
import com.hall_system.reservation_system.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatsServiceImpl implements SeatsService{
  private final SeatsRepository seatsRepository;

  @Autowired
  public SeatsServiceImpl(SeatsRepository seatsRepository) {
    this.seatsRepository = seatsRepository;
  }

  @Override
  public Seats findSeatsBySeatsNumberAndHall(Integer seatNumber, Hall hall) {
    return seatsRepository.findBySeatNumberAndHall(seatNumber, hall);
  }
}
