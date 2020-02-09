package com.hongbeom.wancs.domain;


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
  private String title;
  private String content;
  private int views;
  private char useYn;
  private Timestamp createdDate;
  private Timestamp updatedDate;
  private Category category;
  private User user;

}
