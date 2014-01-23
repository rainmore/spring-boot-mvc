package net.rainmore.platform.web.controllers;

import net.rainmore.platform.GenericSpringTest;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public abstract class GenericControllerTest extends GenericSpringTest {

    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
