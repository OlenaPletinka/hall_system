package com.hall_system.reservation_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private LocalDateTime time;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "hall_id", referencedColumnName = "id")
  private Hall hall;
}
