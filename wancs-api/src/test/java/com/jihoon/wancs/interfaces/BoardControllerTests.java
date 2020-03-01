package com.jihoon.wancs.interfaces;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jihoon.wancs.application.BoardService;
import com.jihoon.wancs.domain.Board;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver.StreamWriting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private BoardService BoardService;

  @Test
  void getList() throws Exception {
    List<Board> boards = new ArrayList<>();
    Board board = Board.builder()
        .boardNo(3L)
        .title("what are you from2222")
        .content("India")
        .views(1)
        .useYN('Y')
        .categoryNo(1)
        .userNo(1)
        .build();
    boards.add(board);

    given(BoardService.getList(board)).willReturn(boards);

    mvc.perform(get("/v1/board"))
        .andExpect(status().isOk())
        //.andExpect(content().string(containsString("\"boardNo\":3")))
        //.andExpect(content().string(containsString("\"title\":\"what are you from2222\"")));
        .andExpect(content().string(containsString("")));
  }
}