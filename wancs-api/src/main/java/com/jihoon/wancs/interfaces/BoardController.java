package com.jihoon.wancs.interfaces;

import com.jihoon.wancs.application.BoardService;
import com.jihoon.wancs.domain.Board;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @GetMapping
  public List<Board> getBoards(
      @RequestParam(value="categoryNo", required = false, defaultValue = "-1") int categoryNo
  ) {
    Board b = new Board();
    b.setCategoryNo(categoryNo);
    return boardService.getList(b);
  }
}