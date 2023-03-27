package com.laiszig.my_movie_plan_backend.controller;

import com.laiszig.my_movie_plan_backend.entities.Genre;
import com.laiszig.my_movie_plan_backend.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genre")
    public List<Genre> getAll() {
        return genreService.findAll();
    }

    @PostMapping("/genre")
    public ResponseEntity<Genre> saveCategory(@RequestBody Genre genre) {
        genreService.saveGenre(genre);
        return new ResponseEntity<>(genre, HttpStatus.CREATED);
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable Integer id) {
        try {
            Genre genre = genreService.getGenre(id);
            return new ResponseEntity<>(genre, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/genre/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable Integer id) {
        try {
            genreService.deleteGenre(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
