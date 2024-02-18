package com.teczarine.moviecatalogue.models;

import lombok.*;

import java.util.List;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRating {
    private List<Rating> ratingsLst;
}
