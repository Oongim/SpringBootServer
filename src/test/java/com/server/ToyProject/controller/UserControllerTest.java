package com.server.ToyProject.controller;

import com.server.ToyProject.repository.UserRepository;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // UserController에서 잡고 있는 Bean 객체에 대해 Mock 형태의 객체를 생성해줌
    @MockBean
    UserRepository userRepository;

    @Test
    @DisplayName("User 컨트롤러 테스트")
    public void getUserTest() throws Exception{
        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        //given(User)
        
        mockMvc.perform(get("/user/all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("expression").exists())
        .andDo(print());

        // verify : 해당 객체의 메소드가 실행되었는지 체크해줌
        //verify(userRepository).get
    }
}
