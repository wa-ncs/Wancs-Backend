package com.jihoon.wancs.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController {

  @GetMapping("/")
  public String hello(){
    return "성공적으로 서버 시작!!";
  }

}

