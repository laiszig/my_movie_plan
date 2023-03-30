package com.laiszig.my_movie_plan_backend.controller.request;

import com.laiszig.my_movie_plan_backend.entities.Genre;
import lombok.Data;

@Data
public class MovieRequest {

        private Integer id;
        private String name;
        private Integer year;
        private String director;
        private String language;
        private String description;
        private Genre genre;
    }

