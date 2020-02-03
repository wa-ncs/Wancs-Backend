package com.soobinnn.eatgo.ex03_eatgo.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
  Logger logger = LoggerFactory.getLogger(WelcomeController.class);

  @GetMapping("/")
  public String hello() {
    logger.trace("trace -- Hello world.");
    logger.debug("debug -- Hello world.");
    logger.info("info -- Hello world.");
    logger.warn("warn -- Hello world.");
    logger.error("error -- Hello world.");
    return "Hello, world!";
  }
}
