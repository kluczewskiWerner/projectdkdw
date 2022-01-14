package pl.kluczewski.currency_converter.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@WithMockUser
class CurrencyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllCurrency() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/currency/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getValueFromPln() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/currency/from/{currency}/{quantity}", "usd", "1500")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetValueFromPln() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/currency/from/{currency}/{quantity}/{date}", "usd", "1500", "2016-04-04")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getValueToPln() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/currency/to/{currency}/{quantity}", "usd", "1500")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetValueToPln() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/currency/to/{currency}/{quantity}/{date}", "usd", "1500", "2016-04-04")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetValueToPlnWrongDate() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/currency/to/{currency}/{quantity}/{date}", "usd", "1500", "2015-12-32")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}