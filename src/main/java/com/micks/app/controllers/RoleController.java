package com.micks.app.controllers;
/**
 * 
 */


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

import com.micks.app.model.Role;
import com.micks.app.model.User;
import com.micks.app.services.DummyRepositoryServiceImpl;
import com.micks.app.services.RepositoryService;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
@Controller("roleController")
@RequestMapping(value = "/roles")
public class RoleController {

    private Log log = LogFactory.getLog(RoleController.class);

    @Inject
    RepositoryService repositoryService = new DummyRepositoryServiceImpl();

    /***************************************************************
     * 
     ***************************************************************/
    public RoleController() {
    }

    /***************************************************************
     * GET LIST OF ROLES
     ***************************************************************/
    @RequestMapping(produces = { "application/json" })
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Role> getRoles() {

        this.log.info("MICK - getUsers returning all roles");

        return this.repositoryService.getRoles();
    }

}
