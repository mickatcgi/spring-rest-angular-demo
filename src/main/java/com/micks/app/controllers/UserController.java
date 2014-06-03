/**
 * 
 */
package com.micks.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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

/***************************************************************
 * @author mick
 *
 ***************************************************************/
@Controller("userController")
@RequestMapping(value = "/users")
public class UserController {

    private Log log = LogFactory.getLog(UserController.class);

    List<User> userList = new ArrayList<>();
    AtomicInteger counter = new AtomicInteger(0);
    AtomicLong idGenerator = new AtomicLong(10);

    /***************************************************************
     * Create some dummy users one time
     ***************************************************************/
    public UserController() {

        /* Build a user list of random users */
        for (long id = 0; id <= 5; id++) {
            String firstName = String.format("FirstName-%s", id);
            String lastName = String.format("LastName-%s", id);
            User u = new User(id, firstName, lastName);
            this.userList.add(u);
        }
    }

    /***************************************************************
     * GET LIST OF USERS
     ***************************************************************/
    @RequestMapping(produces = { "application/json" })
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<User> getUsers() {

        this.log.info("MICK - getUsers returning all users");

        return this.userList;
    }

    /***************************************************************
     * GET INDIVIDUAL USER
     ***************************************************************/
    @RequestMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUser(@PathVariable int id) {

        User u = this.userList.get(id);
        this.log.info(String.format(
            "MICK - GET lookup id = %s. Found User = %s", id, u.toString()));

        return u;
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
            for(User u : this.userList) {
                if (u.getId() == id) {
                    int num = this.counter.incrementAndGet();
                    u.setFirstName(user.getFirstName());
                    u.setLastName(user.getLastName() + " [" + num + "]");
                    this.log.info(String.format(
                        "MICK - PUT UPDATED user = %s", u.toString()));
                }
            }
            
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
            User newUser = new User(this.idGenerator.getAndIncrement(), 
                user.getFirstName(), user.getLastName());
            this.log.info(String.format(
                "MICK - POST CREATED user = %s", newUser.toString()));
            this.userList.add(newUser);
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
        this.userList.removeIf(u -> u.getId() == id);  
        return;
    }
}
