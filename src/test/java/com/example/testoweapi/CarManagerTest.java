package com.example.testoweapi;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import org.hamcrest.Matchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarManagerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFindCarList() throws Exception{

        MockHttpServletRequestBuilder requestBuilder = get("/getCars");

        mockMvc.perform(requestBuilder)
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0]", not(emptyString())));
    }

    @Test
    void shouldFindCertainCar() throws Exception{

        MockHttpServletRequestBuilder requestBuilder = get("/getCars");

        mockMvc.perform(requestBuilder)
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].name", is("Polo")));
    }

    @Test
    void shouldAddCar() throws Exception{

        //language=JSON
        String json = "{\n"
                + " \"id\": \"3\",\n"
                + " \"name\": \"1\",\n"
                + " \"mark\": \"BMW\", \n"
                + " \"mileage\": 35000,\n"
                + " \"production_date\": 2003\n"
                + "}";

        MockHttpServletRequestBuilder requestBuilder = post("/addCar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[].id", Matchers.is("3")))
               .andExpect(jsonPath("$[].name", Matchers.is("1")))
               .andExpect(jsonPath("$[].mark", Matchers.is("BMW")))
               .andExpect(jsonPath("$[].mileage", Matchers.is(35000)))
               .andExpect(jsonPath("$[].production_date", Matchers.is(2003)));
    }

    @Test
    public void shouldDeleteCar() throws Exception {

        mockMvc.perform(delete("/deleteCar/1")
                                     .contentType(MediaType.APPLICATION_JSON))
                                     .andExpect(status().isOk());
    }
}
