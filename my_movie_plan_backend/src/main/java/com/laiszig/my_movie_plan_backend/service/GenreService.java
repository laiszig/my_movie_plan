package com.laiszig.my_movie_plan_backend.service;

import com.laiszig.my_movie_plan_backend.entities.Genre;
import com.laiszig.my_movie_plan_backend.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    public void saveGenre(Genre category) {
        genreRepository.save(category);
    }

    public Genre getGenre(Integer id) {
        return genreRepository.findById(id).get();
    }

    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}
