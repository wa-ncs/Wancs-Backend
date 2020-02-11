package com.jihoon.wancs.Board.application;

import com.jihoon.wancs.Board.domain.BoardRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

  @Autowired
  private BoardRepository boardRepository;


  @Override
  public List<Map<String, Object>> getList() {
    return boardRepository.getList();
  }
}
