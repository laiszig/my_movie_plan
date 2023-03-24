package com.laiszig.my_movie_plan_backend.service;

import com.laiszig.my_movie_plan_backend.commons.ItemAlreadyExistsException;
import com.laiszig.my_movie_plan_backend.entities.Movie;
import com.laiszig.my_movie_plan_backend.repository.GenreRepository;
import com.laiszig.my_movie_plan_backend.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public void saveMovie(Movie movie) {
        if(movieRepository.existsByName(movie.getName())) {
            throw new ItemAlreadyExistsException("The Movie " + movie.getName() + " has already been inserted.");
        } else {
            movie.setName(movie.getName());
            movie.setDescription(movie.getDescription());
            movie.setDirector(movie.getDirector());
            movie.setYear(movie.getYear());
            movie.setLanguage(movie.getLanguage());
            movie.setGenre(genreRepository.findById(movie.getGenre().getId()).get());
            movieRepository.save(movie);
        }
    }

    public List<Movie> searchByGenre(Integer id){
        return movieRepository.findByGenreId(id);
    }

    public void changeStatus (Movie movie) {
        movie.setStatus(!movie.getStatus());
    }

    public Movie getMovie(Integer id) {
        return movieRepository.findById(id).get();
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}
