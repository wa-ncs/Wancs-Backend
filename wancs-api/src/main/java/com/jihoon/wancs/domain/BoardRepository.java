package com.jihoon.wancs.Board.domain;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardRepository {
  List<Map<String, Object>> getList();

}
