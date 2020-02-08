package com.wancs.backend.api.interfaces.board;

import com.wancs.backend.api.domain.board.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

  @Autowired private BoardServiceImpl boardService;

  @GetMapping("/v1/board")
  public String list() {
    return "hello";
  }
}
