package com.laiszig.my_movie_plan_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "showtimes")
@NoArgsConstructor
@AllArgsConstructor
public class Showtime {

    @Id
    @Column(name = "showtime_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = true)
    private Movie movie;

    @Column(name = "showtime")
    private LocalTime showtime;
}
