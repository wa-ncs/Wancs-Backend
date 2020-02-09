package com.hongbeom.wancs.interfaces;

import com.hongbeom.wancs.application.BoardService;
import com.hongbeom.wancs.domain.Board;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    private BoardService boardService;

    @Autowired
    BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/v1/board")
    @ResponseBody
    public List<Board> getBoardAll() {
        return boardService.getBoardAll();
    }
}
