package com.teczarine.movieinfoservice.resources;

import com.teczarine.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public Movie getMoveInfo(@PathVariable("movieId") String movieId){
        return new Movie(movieId, "Test name");
    }
}
