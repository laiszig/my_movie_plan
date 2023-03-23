package com.laiszig.my_movie_plan_backend.service;

import com.laiszig.my_movie_plan_backend.entities.Movie;
import com.laiszig.my_movie_plan_backend.entities.Showtime;
import com.laiszig.my_movie_plan_backend.repository.MovieRepository;
import com.laiszig.my_movie_plan_backend.repository.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;

    public ShowtimeService(ShowtimeRepository showtimeRepository, MovieRepository movieRepository) {
        this.showtimeRepository = showtimeRepository;
        this.movieRepository = movieRepository;
    }

    public void saveShowtime(Showtime showtime) {
        showtime.setShowtime(showtime.getShowtime());
        if (showtime.getMovie() == null) {
            showtime.setMovie(null);
        } else {
            showtime.setMovie(movieRepository.findById(showtime.getMovie().getId()).get());
        }
        showtimeRepository.save(showtime);
    }

    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }



}
