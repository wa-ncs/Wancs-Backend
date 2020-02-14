package com.jihoon.wancs.domain;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardRepository {
  List<Board> getList(Board board);

}
