package com.laiszig.my_movie_plan_backend.controller;

import com.laiszig.my_movie_plan_backend.controller.request.ShowtimeRequest;
import com.laiszig.my_movie_plan_backend.entities.Showtime;
import com.laiszig.my_movie_plan_backend.service.ShowtimeService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping("/showtime")
    public List<Showtime> getAll() {
        return showtimeService.findAll();
    }

    @PostMapping("/showtime")
    public ResponseEntity<Showtime> addShowtime(@RequestBody Showtime showtime) {
        showtimeService.saveShowtime(showtime);
        return new ResponseEntity<>(showtime, HttpStatus.CREATED);
    }

    @PostMapping("/showtime/search")
    public List<Showtime> searchByShowtime(@RequestBody ShowtimeRequest request) {
        return showtimeService.findByShowtime(request.getTime());
    }

    @GetMapping("/showtime/search/{movieId}")
    public List<Showtime> searchByMovieId(@PathVariable Integer movieId) {
        return showtimeService.findByMovieId(movieId);
    }

    @DeleteMapping("/showtime/{id}")
    public ResponseEntity<Showtime> deleteMovie(@PathVariable Integer id) {
        try {
            showtimeService.deleteShowtime(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
