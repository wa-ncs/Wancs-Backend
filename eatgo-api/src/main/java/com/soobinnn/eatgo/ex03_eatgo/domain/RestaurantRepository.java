package com.soobinnn.eatgo.ex03_eatgo.domain;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> findAll();

    Restaurant findById(Long id);
}
