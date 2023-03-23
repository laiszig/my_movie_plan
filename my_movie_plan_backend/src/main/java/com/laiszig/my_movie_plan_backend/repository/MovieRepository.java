package com.laiszig.my_movie_plan_backend.repository;

import com.laiszig.my_movie_plan_backend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    boolean existsByName(String name);

    List<Movie> findByGenreId (Integer genreId);
}
