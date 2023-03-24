package com.laiszig.my_movie_plan_backend.controller;

import com.laiszig.my_movie_plan_backend.controller.request.MovieSearchRequest;
import com.laiszig.my_movie_plan_backend.entities.Movie;
import com.laiszig.my_movie_plan_backend.entities.Showtime;
import com.laiszig.my_movie_plan_backend.service.ShowtimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path = "/showtime")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping("/")
    public List<Showtime> getAll() {
        return showtimeService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Showtime> saveMovie(@RequestBody Showtime showtime) {
        showtimeService.saveShowtime(showtime);
        return new ResponseEntity<>(showtime, HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public List<Showtime> searchByShowtime(@RequestBody LocalTime time) {
        return showtimeService.findByShowtime(time);
    }
}
