package com.teczarine.ratingservice.resources;

import com.teczarine.ratingservice.models.Rating;
import com.teczarine.ratingservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 2);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        return
                UserRating.builder()
                        .ratingsLst(Arrays.asList(
                new Rating("4567", 4),
                new Rating("1234", 2)
                        )).build();
    }
}
