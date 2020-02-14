package com.jihoon.wancs.application;

import com.jihoon.wancs.domain.Board;
import java.util.List;

public interface BoardService {
  List<Board> getList(Board board);
}
