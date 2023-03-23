package com.laiszig.my_movie_plan_backend.repository;

import com.laiszig.my_movie_plan_backend.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    boolean existsByName(String name);
}
