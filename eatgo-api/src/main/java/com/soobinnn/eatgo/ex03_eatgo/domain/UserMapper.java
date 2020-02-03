package com.soobinnn.eatgo.ex03_eatgo.domain;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
  List<Map<String, Object>> getUser();
}
