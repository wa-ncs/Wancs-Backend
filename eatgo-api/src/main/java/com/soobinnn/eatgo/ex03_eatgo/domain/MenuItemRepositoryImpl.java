package com.soobinnn.eatgo.ex03_eatgo.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MenuItemRepositoryImpl implements MenuItemRepository {
  private List<MenuItem> menuItems = new ArrayList<>();

  public MenuItemRepositoryImpl() {
    menuItems.add(new MenuItem("Kimchi"));
  }

  @Override
  public List<MenuItem> findAllByRestaurantId(Long restaurantId) {
    return menuItems;
  }
}
