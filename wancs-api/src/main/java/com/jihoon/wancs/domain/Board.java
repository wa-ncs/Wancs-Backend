package com.jihoon.wancs.Board.domain;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Alias("Board")
public class Board {

  private Long boardNo;
  private int views;
  private Category categoryNo;
  private User userNo;
  private String title;
  private String content;
  private char useYN;
  private Timestamp createDate;
  private Timestamp updateDate;

}
