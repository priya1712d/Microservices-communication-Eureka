package com.teczarine.moviecatalogue.resources;

import com.teczarine.moviecatalogue.models.CatalogItem;
import com.teczarine.moviecatalogue.models.Movie;
import com.teczarine.moviecatalogue.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

       UserRating ratings = restTemplate.getForObject("http://ratings-service/ratings/users/" + userId, UserRating.class);

        return ratings.getRatingsLst().stream().map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "desc", rating.getRating());
                }
        ).collect(Collectors.toList());
    }
}
