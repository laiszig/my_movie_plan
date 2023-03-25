package com.laiszig.my_movie_plan_backend.controller.request;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ShowtimeRequest {

    private LocalTime time;
}
