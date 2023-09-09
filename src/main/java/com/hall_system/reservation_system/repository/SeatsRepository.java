package com.hall_system.reservation_system.repository;

import com.hall_system.reservation_system.entity.Hall;
import com.hall_system.reservation_system.entity.Seats;
import org.springframework.data.repository.CrudRepository;

public interface SeatsRepository extends CrudRepository<Seats, Long> {
  Seats findBySeatNumberAndHall(Integer seatNumber, Hall hall);
}
