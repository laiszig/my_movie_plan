package com.laiszig.my_movie_plan_backend.controller;

import com.laiszig.my_movie_plan_backend.entities.Genre;
import com.laiszig.my_movie_plan_backend.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
