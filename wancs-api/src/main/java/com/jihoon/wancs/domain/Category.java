package com.jihoon.wancs.domain;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
  private int categoryNo;
  private String title;
  private String description;
  private char useYN;
  private Timestamp createDate;
  private Timestamp updateDate;

}
