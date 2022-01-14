package pl.kluczewski.currency_converter.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    public void prepareUser() throws Exception {
        mvc.perform(post("/register").content("{\"email\": \"test@test.com\", \"password\": \"test\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    void shouldLoginAndGetContent() throws Exception {
        prepareUser();

        MvcResult login = mvc.perform(post("/login")
                        .content("{\"email\": \"test@test.com\", \"password\": \"test\"}"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        String token = login.getResponse().getHeader("Authorization");

        mvc.perform(get("/secured").header("Authorization", token))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(content().string("secured"));

        mvc.perform(get("/secured"))
                .andDo(print())
                .andExpect(status().is(401));
    }
}