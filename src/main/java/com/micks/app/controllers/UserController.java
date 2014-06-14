/**
 * 
 */
package com.micks.app.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.micks.app.model.User;
import com.micks.app.services.DummyRepositoryServiceImpl;
import com.micks.app.services.RepositoryService;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
@Controller("userController")
@RequestMapping(value = "/users")
public class UserController {

    private Log log = LogFactory.getLog(UserController.class);

    @Inject
    RepositoryService repositoryService = new DummyRepositoryServiceImpl();

    /***************************************************************
     * Create some dummy users one time
     ***************************************************************/
    public UserController() {
    }

    /***************************************************************
     * GET LIST OF USERS
     ***************************************************************/
    @RequestMapping(produces = { "application/json" })
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<User> getUsers() {

        this.log.info("MICK - getUsers returning all users");

        return this.repositoryService.getUsers();
    }

    /***************************************************************
     * GET INDIVIDUAL USER
     ***************************************************************/
    @RequestMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUser(@PathVariable int id) throws Exception {

        User user = this.repositoryService.getUser(id);
        this.log.info(String.format(
            "MICK - GET lookup id = %s. Found User = %s", id, user.toString()));

        return user;
    }

    /************************************************************************
     * UPDATE USER NAME GIVEN THE ID
     * 
     * @param id
     *************************************************************************/
    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void putUser(@PathVariable int id, @RequestBody User user,
        BindingResult result) throws BindException, Exception {

        if (result.hasErrors()) {
            this.log.error("MICK: PUT - " + result.getAllErrors().toString());
            throw new BindException(result);
        } else {
            this.repositoryService.updateUser(user);
            //if (true) {
            //    // Dummy exception to trigger Angular error handling code
            //    throw new Exception("Bogus update error from Mick");
            //}
        }
        return;
    }

    /************************************************************************
     * CREATE NEW USER - ID AND NAME
     * 
     * @throws BindException
     *************************************************************************/
    @RequestMapping(value = "/create", method = RequestMethod.POST,
        produces = { "application/json" }, consumes = { "application/json" })
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User createUser(@RequestBody User user, BindingResult result,
        HttpServletResponse response) throws BindException {

        if (result.hasErrors()) {
            this.log.error(result.getAllErrors().toString());
            throw new BindException(result);
        } else {
            this.repositoryService.addUser(user);
            this.log.info(String.format(
                "MICK - POST CREATED user = %s", user.toString()));
        }

        return user;
    }

    /************************************************************************
     * DELETE THE USER GIVEN THE ID
     * 
     * @param id
     *************************************************************************/
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {

        this.log.info(String.format("MICK - DELETING user with id = %s", id));
        this.repositoryService.deleteUser(id);
        return;
    }
}
