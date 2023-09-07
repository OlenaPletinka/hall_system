package com.hall_system.reservation_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservations {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

 @OneToOne
 @JoinColumn(name = "seats_id", referencedColumnName = "id")
  private Seats seats;

 @OneToOne
 @JoinColumn(name = "event_id", referencedColumnName = "id")
 private Event event;

 @Column
  private  String reservedBy;

 @Column
  private Timestamp timestamp;
}
