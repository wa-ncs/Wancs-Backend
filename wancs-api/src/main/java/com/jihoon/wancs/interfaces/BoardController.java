package com.jihoon.wancs.Board.interfaces;

import com.jihoon.wancs.Board.application.BoardService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

  @Autowired
  private BoardService boardService;

  @GetMapping("/v1/board")
  public List<Map<String, Object>> getBoards() {
    return boardService.getList();
  }

}