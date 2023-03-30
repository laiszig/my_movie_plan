package com.laiszig.my_movie_plan_backend.commons;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message) {
        super(message);
    }
}
