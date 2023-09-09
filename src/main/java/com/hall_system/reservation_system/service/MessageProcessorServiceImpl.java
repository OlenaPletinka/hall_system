package com.hall_system.reservation_system.service;

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
public class MessageProcessorServiceImpl implements MessageProcessorService{
  private final Convertor convertor;

  @Autowired
  public MessageProcessorServiceImpl(Convertor convertor) {
    this.convertor = convertor;
  }

  @Override
  public List<Reservations> convertMessageToReservations(List<LinkedHashMap> dtos) {
    List<Reservations>reservations = new ArrayList<>();
    for (LinkedHashMap dto:dtos){
      reservations.add(convertor.convertMessageDtoToReservations(dto));
    }
    return reservations;
  }
}
