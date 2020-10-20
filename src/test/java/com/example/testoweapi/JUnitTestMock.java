package com.example.testoweapi;

import com.example.testoweapi.model.Car;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class JUnitTestMock {
    @Mock
    private Car car;

    @Autowired
    private MockMvc mockMvc;
    @Test
    void shouldFindCarList() throws Exception{
        String json = "{\n"
                + " \"name\": \"1\",\n"
                + " \"mark\": \"BMW\", \n"
                + " \"mileage\": 35000,\n"
                + " \"production_date\": 2003\n"
                + " \"izofix\": true\n"
                + " \"usedcar\": true\n"
                + " \"vin\": 01234567890123456\n"
                + "}";
        MockHttpServletRequestBuilder requestBuilder = post("/addCar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
               .andExpect(status().isOk());
    }
}
