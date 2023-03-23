package com.laiszig.my_movie_plan_backend.repository;

import com.laiszig.my_movie_plan_backend.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
}
