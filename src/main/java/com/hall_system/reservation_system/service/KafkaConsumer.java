package com.hall_system.reservation_system.service;

import com.hall_system.reservation_system.entity.Reservations;
import com.hall_system.reservation_system.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class KafkaConsumer {
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

  private final MessageProcessorService messageProcessorService;
  private final ReservationService reservationService;

  @Autowired
  public KafkaConsumer(MessageProcessorService messageProcessorService, ReservationService reservationService) {
    this.messageProcessorService = messageProcessorService;
    this.reservationService = reservationService;

  }

  @KafkaListener(topics = AppConstants.RESERVATION_CREATION_TOPIC, groupId = AppConstants.RESERVATION_CREATION_GROUP_ID)
  public void consumeReservation(List<LinkedHashMap> dtos){
    LOGGER.info(String.format("Message with %d reservations was received.", dtos.size()));
    List<Reservations> reservations = messageProcessorService.convertMessageToReservations(dtos);
    reservationService.createReservations(reservations);
  }
}
