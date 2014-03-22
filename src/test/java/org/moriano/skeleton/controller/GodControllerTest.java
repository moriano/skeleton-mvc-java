package org.moriano.skeleton.controller;

import org.moriano.skeleton.mock.GodMock;
import org.moriano.skeleton.model.God;
import org.moriano.skeleton.service.GodService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created with IntelliJ IDEA.
 * User: moriano
 * Date: 16/09/13
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class GodControllerTest {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Mock
    private GodService godService;

    @Autowired
    @InjectMocks
    private GodController godController;

    private MockMvc mockMvc;

    private final static ObjectMapper jsonMapper = new ObjectMapper();

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.godController).build();
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();  //Bypass mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void list() throws Exception {
        List<God> allGods = GodMock.allGods();
        when(this.godService.getAll()).thenReturn(allGods);

        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get("/god/list");

        String rawJson = this.mockMvc.perform(get).andExpect(status().isOk()).andReturn().
                getResponse().getContentAsString();

        List<God> deserializedGods = jsonMapper.readValue(rawJson,
                new TypeReference<List<God>>(){});

        assertEquals(deserializedGods, allGods);

    }

    @Test
    public void list_InvalidHTTPMethod() throws Exception{
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/god/list");

        this.mockMvc.perform(post).andExpect(status().is(405));
    }


}
