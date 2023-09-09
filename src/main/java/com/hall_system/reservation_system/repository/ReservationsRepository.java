package com.hall_system.reservation_system.repository;

import com.hall_system.reservation_system.entity.Reservations;
import org.springframework.data.repository.CrudRepository;

public interface ReservationsRepository  extends CrudRepository<Reservations, Long> {
}
