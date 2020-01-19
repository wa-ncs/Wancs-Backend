# Eat Go Project
패스트캠퍼스 온라인 강의 아샬님 예제 따라 하기

# 요구사항 작성방법

## 무엇이 문제인가? - 불편함
분야 - Domain
올바른 문제 찾기

##사용자 스토리
- 사용자 입장에서 기능을 서술
(사용자)는 (가치)를 위해 (기능)을 할 수 있다.

### 사용자는 누구인가?
고객, 가게, 관리자

### 사용자 스토리 예제
ex) 고객은 뭘 먹고 싶은지 발견할 수 있도록 가게 목록을 볼 수 있다.

고객은 정확히 먹고 싶은 게 뭔지 확인하기 위해 가게의 메뉴를 볼 수 있다.

고객은 좋은 가게인지 알 수 있도록 평점을 확인할 수 있다.

고객은 선택의 폭을 좁히기 위해 가게 목록을 분류에 따라 볼 수 있다.

고객은 나와 남을 위해 가게에 평점과 리뷰를 남길 수 있다.

고객은 나중에 찾아보기 쉽도록 가게를 즐겨찾기에 추가할 수 있다.

고객은 가게에서 기다리지 않기 위해 가게에 인원, 메뉴를 예약할 수 있다.

가게는 관심 있는 고개을 받기 위해 예약 요청을 볼 수 있다.

가게는 더 나은 서비스를 위해 예약 요청에 응답할 수 있다.

관리자는 고객이 서비스를 쓸 수 있도록 가게 정보를 등록할 수 있다.

## 요구사항 변경은 반복된다.
## 계획을 세우자

## 어떻게 만들것 인가? 
### 도메인 모델링
Restaurant
Menu Item
Food&Beverages
User
Favorite
Review
Reservation

### 시스템 아키텍처
-제약조건
다른 부분
공통 부분

#### 3-tier rchitecture
Presentation - Business - Data Source

#### Backend Architecture 
Layered Architecture 
- UI Layer (Controller)
- Application Layer
- Domain Layer (Repository)
- Infrastructure Layer

## 기술 스택
Java
Spring Boot
REST API


------
# 프로젝트 생성
boot 시작하기
start.spring.io

__dependency__
- Spring Web
- Spring Boot DevTools
- Lombok

## Multi Part Project 생성방법
1. 폴더 생성 - src, build.gradle 넣음. 
2. settings.gradle 에 include '폴더명' 추가

# 테스트 주도개발
- 목표 주도 개발, 사용자 중심 개발, 인터페이스 중심 개발

올바르게 작동 - 깔끔한 코드

## TDD Cycle
1. Red - Test
2. Green - Success
3. Refactoring


## Rest API (REpresentational State Transfer)

-
URI (Uniform Resource Identifier)
URL (Uniform Resource Location)

Collection : Read, Create
Member : Read(Detail), update, delete


## 의존성 (Dependency)
A는 B를 사용 -> A는 B에 의존

B의 변화가 A에 영향

ex) Controller는 Repository에 의존
1. Repository 생성
2. Controller에 Repository를 연결

### Spirng IoC Container
의존관계를 자동으로 연결해줌
- @Component
- @Autowired

\* 의존관계를 사용할 때는 Test Case에 __@SpyBean__ 을 추가해줘야함 

### Mock Object
스프링은 Mokito라는 프레임워크를 사용함

Spring Test IoC컨테이너를 이용해서 의존성을 관리하는 것을 활용
자바에 있는 기본 객체를 이용해서 테스트
Spring Test를 사용해서 테스트하는게 컨테이너가 실행되는 것을 기다려야 하기 떄문에 느리다

### POJO
스프링은 Plain Old Java Object 를 권장함.
전통적인 자바 오브젝트 권장

```java
// before
package com.soobinnn.eatgo.ex03_eatgo.interfaces;


import com.soobinnn.eatgo.ex03_eatgo.application.RestaurantService;
import com.soobinnn.eatgo.ex03_eatgo.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;
        
    @SpyBean(RestaurantRepositoryImpl.class)
    private RestaurantRepository restaurantRepository;

    @SpyBean(MenuItemRepositoryImpl.class)
    private MenuItemRepository menuItemRepository;

    @SpyBean(RestaurantService.class)
    private RestaurantService restaurantService;

    //perform은 예외가 나올 수 있으니 Exception을 해야함.
    @Test
    public void list() throws Exception {
        mvc.perform((get("/restaurants")))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Bob zip\"")
                ));
    }

    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Bob zip\"")
                ))
                .andExpect(content().string(
                        containsString("Kimchi")
                ));

        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":2020")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Cyber Food\"")
                ));
    }
}
```
```java
//after
package com.soobinnn.eatgo.ex03_eatgo.interfaces;

import com.soobinnn.eatgo.ex03_eatgo.application.RestaurantService;
import com.soobinnn.eatgo.ex03_eatgo.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Joker House", "Seoul"));

        given(restaurantService.getRestaurants()).willReturn(restaurants);

        mvc.perform((get("/restaurants")))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Joker House\"")
                ));
    }

    @Test
    public void detail() throws Exception {
        Restaurant restaurant1 = new Restaurant(1004L, "JOKER House", "Seoul");
        restaurant1.addMenuItem(new MenuItem("Kimchi"));

        Restaurant restaurant2 = new Restaurant(2020L, "Cyber Food", "Seoul");

        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);
        given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"JOKER House\"")
                ))
                .andExpect(content().string(
                        containsString("Kimchi")
                ));

        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":2020")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Cyber Food\"")
                ));
    }
}
```
Controller는 이 Service를 활용한다 라는 이 사실에만 집중할 뿐이지
이 Service가 어떻게 작동하는지는 중요하지 않다. - Mock Object를 사용하는 이유
    
```java
// before
package com.soobinnn.eatgo.ex03_eatgo.application;

import com.soobinnn.eatgo.ex03_eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    private RestaurantRepository restaurantRepository;

    private MenuItemRepository menuItemRepository;

    // 모든 테스트를 실행하기 전에 Before가 실행됨.
    @Before
    public void setUp() {
        restaurantRepository = new RestaurantRepositoryImpl();
        menuItemRepository = new MenuItemRepositoryImpl();

        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    @Test
    public void getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);

        assertThat(restaurant.getId(), is(1004L));
    }

    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId(), is(1004L));

        MenuItem menuItem = restaurant.getMenuItems().get(0);

        assertThat(menuItem.getName(), is("Kimchi"));
    }
}

```    
```java
// after
package com.soobinnn.eatgo.ex03_eatgo.application;

import com.soobinnn.eatgo.ex03_eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private MenuItemRepository menuItemRepository;

    // 모든 테스트를 실행하기 전에 Before가 실행됨.
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockRestaurantRespository();
        mockMenuItemRepository();

        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    private void mockRestaurantRespository() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        restaurants.add(restaurant);

        given(restaurantRepository.findAll()).willReturn(restaurants);
        given(restaurantRepository.findById(1004L)).willReturn(restaurant);
    }

    private void mockMenuItemRepository() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));
        
        given(menuItemRepository.findAllByRestaurantId(1004L))
                .willReturn(menuItems);
    }

    @Test
    public void getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);

        assertThat(restaurant.getId(), is(1004L));
    }

    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId(), is(1004L));

        MenuItem menuItem = restaurant.getMenuItems().get(0);

        assertThat(menuItem.getName(), is("Kimchi"));
    }
}

```
스프링에서 사용하는 MockBean, 기본자바객체
Mockito 활용 가짜 데이터사용하는 것 비교해서 사용
어떤경우에 이것을 써야하는가?