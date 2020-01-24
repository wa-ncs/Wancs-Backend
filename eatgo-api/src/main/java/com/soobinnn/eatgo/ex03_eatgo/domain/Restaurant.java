package com.soobinnn.eatgo.ex03_eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

  private final Long id;
  private final String name;
  private final String address;
  private List<MenuItem> menuItems = new ArrayList<>();

  public Restaurant(Long id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getInformation() {
    return name + " in Seoul";
  }

  public String getAddress() {
    return address;
  }

  public List<MenuItem> getMenuItems() {
    return menuItems;
  }

  public void setMenuItems(List<MenuItem> menuItems) {
    for (MenuItem menuItem : menuItems) {
      addMenuItem(menuItem);
    }
  }

  public void addMenuItem(MenuItem menuItem) {
    menuItems.add(menuItem);
  }
}
