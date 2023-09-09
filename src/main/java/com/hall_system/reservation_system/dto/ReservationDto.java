package com.hall_system.reservation_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  public class ReservationDto {
    private String reservedBy;
    private Integer seatsNumber;
    private String eventName;
    private LocalDateTime eventTime;
  }


