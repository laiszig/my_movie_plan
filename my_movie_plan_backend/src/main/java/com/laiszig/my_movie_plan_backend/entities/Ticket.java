package com.laiszig.my_movie_plan_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tickets")
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = true)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = true)
    private Showtime showtime;

    @Column(name = "ticket_price")
    private BigDecimal price;
}
