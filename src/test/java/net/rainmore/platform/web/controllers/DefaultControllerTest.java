package net.rainmore.platform.web.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DefaultControllerTest extends GenericControllerTest {

    @InjectMocks
    DefaultController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testHome() throws Exception {
        this.mockMvc.perform(get("/").param("page", "0").param("size", "20"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.data.content").isArray())
        ;
    }

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/form"))
                .andDo(print())
                .andExpect(status().isOk())
        ;

    }
}
