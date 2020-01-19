package com.soobinnn.eatgo.ex03_eatgo.domain;

import java.util.List;

public interface MenuItemRepository {
    List<MenuItem> findAllByRestaurantId(Long restaurantId);
}
