package com.soobinnn.eatgo.ex03_eatgo.application;

import com.soobinnn.eatgo.ex03_eatgo.domain.MenuItem;
import com.soobinnn.eatgo.ex03_eatgo.domain.MenuItemRepository;
import com.soobinnn.eatgo.ex03_eatgo.domain.Restaurant;
import com.soobinnn.eatgo.ex03_eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository
            , MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }

    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }


//    public Restaurant getRestaurantById(Long id) {
//        Restaurant restaurant = restaurantRepository.findById(id)
//
//        return restaurant;
//    }
}
