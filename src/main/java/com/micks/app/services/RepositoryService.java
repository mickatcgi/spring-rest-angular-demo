/**
 * 
 */
package com.micks.app.services;

import java.util.List;

import com.micks.app.model.Role;
import com.micks.app.model.User;

/***************************************************************
 * To keep it simple just implement standard CRUD methods
 * @author mick
 *
 ***************************************************************/
public interface RepositoryService {
    
    // Return all users
    public abstract List<User> getUsers();
    
    // Get user given the id
    public abstract User getUser(long id) throws Exception;
    
    // Handles create user POST
    public abstract void addUser(User user);
    
    // Handles update user PUT
    public abstract void updateUser(User user);
    
    // Delete user given the id
    public abstract void deleteUser(long id);
    
    // Get a list of roles for each user to choose
    public abstract List<Role> getRoles();
}
