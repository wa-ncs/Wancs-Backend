package com.soobinnn.eatgo.ex03_eatgo.application;

import com.soobinnn.eatgo.ex03_eatgo.domain.UserMapper;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserMapper userMapper;

  @Autowired
  UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public List<Map<String, Object>> getUser() {
    return userMapper.getUser();
  }
}
