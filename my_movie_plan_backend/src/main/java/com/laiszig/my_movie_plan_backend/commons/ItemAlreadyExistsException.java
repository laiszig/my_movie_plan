package com.laiszig.my_movie_plan_backend.commons;

public class ItemAlreadyExistsException extends RuntimeException{

    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
