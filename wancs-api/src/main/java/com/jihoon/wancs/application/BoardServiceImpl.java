package com.jihoon.wancs.application;

import com.jihoon.wancs.domain.Board;
import com.jihoon.wancs.domain.BoardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

  final private BoardRepository boardRepository;

  @Autowired
  public BoardServiceImpl(BoardRepository boardRepository){
    this.boardRepository=boardRepository;
  }


  @Override
  public List<Board> getList(Board board) {
    return boardRepository.getList(board);
  }
}
