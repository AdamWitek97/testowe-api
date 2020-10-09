package com.example.testoweapi;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import org.hamcrest.Matchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CarManagerTest {

    @Mock
    private Car car;

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

        MockHttpServletRequestBuilder requestBuilder = delete("/deleteCar/1");

        mockMvc.perform(requestBuilder
                                     .contentType(MediaType.APPLICATION_JSON))
                                     .andExpect(status().isOk());

/*        MockHttpServletRequestBuilder requestBuilder1 = get("/getCars/Polo");
        mockMvc.perform(requestBuilder1
                                     .contentType(MediaType.APPLICATION_JSON))
                                     .andExpect(status().isOk());*/
       /* verify(mockMvc, (VerificationMode) delete("/deleteCar/1"));
        verifyNoInteractions(requestBuilder);*/
    }
}
