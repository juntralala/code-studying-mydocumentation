package com.juntralala.controller;

import com.juntralala.service.HelloService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerMockTest {

    private MockMvc mockMvc;

    @MockitoBean                            // <- mengoverride bean yang ada didalam ApplicationContext
    private HelloService helloService;

    @Autowired
    public void inject(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    protected void setup() {
        Mockito.when(helloService.hello(Mockito.anyString())).thenReturn("Hello Guys");
    }

    @Test
    void hello() throws Exception {
        mockMvc.perform(
                get("/hello").queryParam("name", "ujun")
        ).andExpectAll(
                status().isOk(),
                content().string(containsString("Hello Guys"))
        );

        Mockito.verify(helloService, Mockito.times(1)).hello("ujun");
    }

}
