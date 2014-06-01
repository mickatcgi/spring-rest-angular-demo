/******************************************************************************
 * File: 			UserControllerIntegrationTest.java
 * Created date:	Dec 8, 2013
 * Created time:	12:19:07 PM
 * User:			mick
 * Version :		1.0
 *****************************************************************************/
package com.micks.app.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static com.micks.app.controllers.fixtures.UserRestFixture.getDefaultUser;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.micks.app.config.Application;

/******************************************************************************
 * Class description....
 * 
 * @author mick
 * @version 1.0
 *****************************************************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserControllerIntegrationTest {

    @Inject
    WebApplicationContext wac;

    private MockMvc mockMvc;

    /************************************************************************
     * Method description...
     * 
     *************************************************************************/
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    /************************************************************************
    * Method description...
    *
    * @throws Exception
    *************************************************************************/
    @Test
    public void getJsonUserList() throws Exception {
        this.mockMvc.perform(get("/users").accept(MediaType.ALL)).andDo(
            print()).andExpect(status().isOk()).andExpect(
            content().contentType("application/json"));

    }

    /************************************************************************
    * Method description...
    *
    * @throws Exception
    *************************************************************************/
    @Test
    public void getJsonUser() throws Exception {
        this.mockMvc.perform(get("/users/{id}.json", "1")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
            //.andExpect(content().contentType(null));
    }

    /************************************************************************
     * Method description...
     * 
     * @throws Exception
     *************************************************************************/
    @Test
    public void updateJsonUser() throws Exception {

        this.mockMvc
            .perform(put("/users/{id}/update", 3L)
            .content(getDefaultUser())
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.ALL))
            .andDo(print())
            .andExpect(status().is(204)); // No content status
    }

    /************************************************************************
     * Method description...
     * 
     * @throws Exception
     *************************************************************************/
    @Ignore
    public void getJsonUserNotFound() throws Exception {
    }

    /************************************************************************
     * Method description...
     * 
     * @throws Exception
     *************************************************************************/
    @Ignore
    public void deleteJsonUser() throws Exception {
    }

    /************************************************************************
     * Method description...
     * 
     * @throws Exception
     *************************************************************************/
    @Ignore
    public void createJsonUser() throws Exception {
    }

    /************************************************************************
     * Method description...
     * 
     * @throws Exception
     *************************************************************************/
    @Ignore
    public void createTextBadRequestUser() throws Exception {
    }
    

}
