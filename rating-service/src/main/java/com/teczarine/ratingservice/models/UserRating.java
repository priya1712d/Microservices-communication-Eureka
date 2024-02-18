package com.teczarine.ratingservice.models;

import lombok.*;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRating {
    private List<Rating> ratingsLst;
}
