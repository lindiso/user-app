package com.lindiso.black.swan.manage.users;

import com.lindiso.black.swan.manage.users.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
@PowerMockIgnore("jdk.internal.reflect.*")
@RunWith(PowerMockRunner.class)
public class UserAppMockTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController restController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
    }

    @Test
    public void createUserTest() throws Exception {
      /*  mockMvc.perform(MockMvcRequestBuilders.patch("/api/user").accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.parseMediaType("application/json")))
                .andExpect(MockMvcResultMatchers.status().isOk());*/
    }

    @Test
    public void updateUserTest() throws Exception {
       /* mockMvc.perform(MockMvcRequestBuilders.patch("/api/user").accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.parseMediaType("application/json"))
        .param("id", "2114"))
                .andExpect(MockMvcResultMatchers.status().isOk());*/
    }



}
