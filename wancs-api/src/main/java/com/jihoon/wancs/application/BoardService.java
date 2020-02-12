package com.jihoon.wancs.application;

import com.jihoon.wancs.domain.Board;
import java.util.List;
import java.util.Map;

public interface BoardService {
  List<Board> getList(Board b);
}
