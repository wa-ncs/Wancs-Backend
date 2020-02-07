package com.soobinnn.eatgo.ex03_eatgo.interfaces;

import com.soobinnn.eatgo.ex03_eatgo.application.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

  private UserService userService;

  @Autowired
  UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user")
  @ResponseBody
  public List<Map<String, Object>> getEmployee() {
    return userService.getUser();
  }
}
