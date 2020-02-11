package com.jihoon.wancs.Board.domain;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private int userNo;
  private String Id;
  private String email;
  private String password;
  private char useYN;
  private Timestamp createDate;
  private Timestamp updateDate;
}
