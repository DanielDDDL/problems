package br.mackenzie.lfs.controllers;

import br.mackenzie.lfs.Application;
import br.mackenzie.lfs.service.SomeOtherService;
import br.mackenzie.lfs.service.SomeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = InitialController.class)
@WebMvcTest
public class InitialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SomeService service;

    @Before
    public void setup(){
        doNothing().when(service).someOperation();
    }

//    @Test
//    public void testingSomething() throws Exception {
//        mockMvc.perform(get("/")).andExpect(view().name("index"))
//                                              .andExpect(model().attribute("message","Hello World!"));
//    }

}
