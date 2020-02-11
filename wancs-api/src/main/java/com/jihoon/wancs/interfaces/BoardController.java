package com.jihoon.wancs.interfaces;

import com.jihoon.wancs.application.BoardService;
import com.jihoon.wancs.domain.Board;
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
  public List<Board> getBoards() {
    return boardService.getList();
  }

}