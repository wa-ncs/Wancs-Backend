package com.wancs.backend.api.interfaces.board;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {

  @Autowired private MockMvc mvc;

  @Test
  public void list() throws Exception {
    mvc.perform((get("/v1/board")))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"id\":1004")));
    //        .andExpect(content().string(containsString("\"name\":\"Joker House\"")));
  }
}
