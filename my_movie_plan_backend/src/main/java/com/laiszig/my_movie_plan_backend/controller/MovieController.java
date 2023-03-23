package com.laiszig.my_movie_plan_backend.controller;

import com.laiszig.my_movie_plan_backend.controller.request.MovieSearchRequest;
import com.laiszig.my_movie_plan_backend.entities.Movie;
import com.laiszig.my_movie_plan_backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<Movie> getAll() {
        return movieService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public List<Movie> searchMovie(@RequestBody MovieSearchRequest search) {
        return movieService.searchByCategory(search.getGenreId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
        try {
            Movie movie = movieService.getMovie(id);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Integer id) {
        try {
            movieService.deleteMovie(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
