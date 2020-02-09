package com.hongbeom.wancs.application;

import com.hongbeom.wancs.domain.Board;
import com.hongbeom.wancs.domain.BoardMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

  private BoardMapper boardMapper;

  @Autowired
  BoardServiceImpl(BoardMapper boardMapper) { this.boardMapper = boardMapper; }

  @Override
  public List<Board> getBoardAll() {
    return boardMapper.getBoardAll();
  }
}
