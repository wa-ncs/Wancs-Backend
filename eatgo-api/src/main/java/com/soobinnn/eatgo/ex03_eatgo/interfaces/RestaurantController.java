package com.soobinnn.eatgo.ex03_eatgo.interfaces;

import com.soobinnn.eatgo.ex03_eatgo.application.RestaurantService;
import com.soobinnn.eatgo.ex03_eatgo.domain.MenuItem;
import com.soobinnn.eatgo.ex03_eatgo.domain.MenuItemRepository;
import com.soobinnn.eatgo.ex03_eatgo.domain.Restaurant;
import com.soobinnn.eatgo.ex03_eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        // List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }
}
