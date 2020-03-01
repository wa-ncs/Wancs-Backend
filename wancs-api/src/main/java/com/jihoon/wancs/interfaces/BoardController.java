package com.jihoon.wancs.interfaces;

import com.jihoon.wancs.application.BoardService;
import com.jihoon.wancs.domain.Board;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/board")
public class BoardController {

  final private BoardService boardService;

  //순환 참조를 막기 위해 필드 인젝션이 아닌 생성자 인젝션 사용
  @Autowired
  public BoardController(BoardService boardService){
    this.boardService = boardService;
  }

  @GetMapping
  public List<Board> getList(
      @RequestParam(value="categoryNo", required = false, defaultValue = "-1") int categoryNo
  ) {
    Board board = new Board();
    board.setCategoryNo(categoryNo);
    return boardService.getList(board);
  }

  @PostMapping
  public void addBoard(){

  }
}