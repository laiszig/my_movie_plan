package com.laiszig.my_movie_plan_backend.service;

import com.laiszig.my_movie_plan_backend.commons.MovieNotFoundException;
import com.laiszig.my_movie_plan_backend.entities.Movie;
import com.laiszig.my_movie_plan_backend.entities.Showtime;
import com.laiszig.my_movie_plan_backend.repository.MovieRepository;
import com.laiszig.my_movie_plan_backend.repository.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;

    public ShowtimeService(ShowtimeRepository showtimeRepository, MovieRepository movieRepository) {
        this.showtimeRepository = showtimeRepository;
        this.movieRepository = movieRepository;
    }

    public void saveShowtime(Showtime showtime) {
        Optional<Movie> movieOptional = movieRepository.findById(showtime.getMovie().getId());
        Movie movie = movieOptional.orElseThrow(() -> new MovieNotFoundException("Movie not found for id: " + showtime.getMovie().getId()));
        showtime.setMovie(movie);
        showtime.setTime(showtime.getTime());
        showtimeRepository.save(showtime);
    }

    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    public List<Showtime> findByShowtime(LocalTime time) {
        return showtimeRepository.findByTime(time);
    }

    public List<Showtime> findByMovieId(Integer movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }

    public void deleteShowtime(Integer id) {
        showtimeRepository.deleteById(id);
    }

}
