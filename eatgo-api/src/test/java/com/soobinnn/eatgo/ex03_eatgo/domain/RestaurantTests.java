package com.soobinnn.eatgo.ex03_eatgo.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RestaurantTests {

  @Test
  public void creation() {
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

    assertThat(restaurant.getId(), is(1004L));
    assertThat(restaurant.getName(), is("Bob zip"));
    assertThat(restaurant.getAddress(), is("Seoul"));
  }

  @Test
  public void information() {
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
    assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
  }
}
