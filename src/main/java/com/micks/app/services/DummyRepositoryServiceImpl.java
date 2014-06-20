/**
 * 
 */
package com.micks.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.micks.app.model.Role;
import com.micks.app.model.User;

/***************************************************************
 * Dummy repository implementation. Replace with real one later 
 * using the same Interface. A repository is a facade for a
 * database or other persistent store.
 * 
 * @author mick
 ***************************************************************/
@Service
public class DummyRepositoryServiceImpl implements RepositoryService {

    private Log log = LogFactory.getLog(DummyRepositoryServiceImpl.class);

    // Initialize our id generator (primary key simulator)
    private AtomicLong generatedUserId = new AtomicLong(0);
    private AtomicLong generatedRoleId = new AtomicLong(0);

    // Use a map for easy insertion and retrieval - simulate a DB
    private Map<Long, User> userMap = new HashMap<>();
    private List<Role> roles = new ArrayList<>();

    // Seed the repository with dummy data.
    private String[][] userArray = {
        { "Billybob", "Thornton" },
        { "Jimbob", "Pitt" },
        { "Bobby sue", "Clinton" },
        { "Abraham", "Lincoln" },
        { "Jeremiah", "Bullfrog" }
    };
    
    private String [] rolesArray = {"Member", "Admin", "Guest"};

    /***************************************************************
     * 
     ***************************************************************/
    public DummyRepositoryServiceImpl() {
        
        // Initialize roles first because they are used by user
        this.initDummyRoleList();
        
        // Initialize users last since they need roles;
        this.initDummyUserList();
    }

    /***************************************************************
     * This DUMMY implementation hard-codes a list of users. We can replace this
     * repository impl with a real one later and leave the interface in place.
     ***************************************************************/
    public void initDummyUserList() {
        // Convert the string array to a HashMap for easy access
        for (String[] userNames : this.userArray) {
            Long id = this.generatedUserId.getAndIncrement();
            User user = new User(id,
                userNames[0],
                userNames[1],
                this.getRole(this.getRandomRoleId()),
                true);
            this.userMap.put(id, user);
        }
        log.info("MICK - Repository initializing dummy user list");
    }

    /***************************************************************
     * This DUMMY implementation hard-codes a list of rles. We can replace this
     * repository impl with a real one later and leave the interface in place.
     ***************************************************************/
    public void initDummyRoleList() {
        // Convert the string array to a HashMap for easy access
        for (String roleName : this.rolesArray) {
            Long id = this.generatedRoleId.getAndIncrement();
            Role role = new Role(id, roleName);
            this.roles.add(role);
        }
        log.info("MICK - Repository initializing dummy role list");
    }

    /***************************************************************
     * (non-Javadoc)
     * 
     * @see com.micks.app.services.RepositoryService#getUsers()
     ***************************************************************/
    @Override
    public List<User> getUsers() {
        return new ArrayList<User>(this.userMap.values());
    }

    /***************************************************************
     * (non-Javadoc)
     * 
     * @see com.micks.app.services.RepositoryService#getUser(int)
     ***************************************************************/
    @Override
    public User getUser(long id) throws Exception {
        User foundUser = null;
        if (userExists(id)) {
            foundUser = this.userMap.get(id);
        } else {
            throw new Exception("User not found. Id = " + id);
        }
        return foundUser;
    }

    /***************************************************************
     * (non-Javadoc)
     * 
     * @see com.micks.app.services.RepositoryService#saveUser(com.micks.app.model.User)
     ***************************************************************/
    @Override
    public void updateUser(User user) {
        if (userExists(user.getId())) {
            // Update existing user with contents of user we got
            User existingUser = this.userMap.get(user.getId());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setRole(user.getRole());
            existingUser.setEnabled(user.isEnabled());
            log.info("MICK - update user = " + existingUser.toString());
        } else {
            log.info("MICK - update user NOT FOUND = " + user.toString());
        }
    }

    /***************************************************************
     * (non-Javadoc)
     * 
     * @see com.micks.app.services.RepositoryService#saveUser(com.micks.app.model.User)
     ***************************************************************/
    @Override
    public void addUser(User user) {
        // Create new user - give the user we got an Id and store it
        long id = this.generatedUserId.incrementAndGet();
        user.setId(id);
        log.info("MICK - creating new user = " + user.toString());
        this.userMap.put(id, user);

    }

    /***************************************************************
     * (non-Javadoc)
     * 
     * @see com.micks.app.services.RepositoryService#deleteUser(com.micks.app.model.User)
     ***************************************************************/
    @Override
    public void deleteUser(long id) {
        if (userExists(id)) {
            this.userMap.remove(id);
        }
    }

    /***************************************************************
     * @param id
     * @return
     ***************************************************************/
    private boolean userExists(long id) {
        return this.userMap.containsKey(id);
    }
    
    /***************************************************************
     * @return
     ***************************************************************/
    public List<Role> getRoles() {
        return this.roles;
    }
    
    /***************************************************************
     * @param id
     * @return
     ***************************************************************/
    public Role getRole(long id) {
        return this.roles.get((int)id);
    }
    
    /***************************************************************
     * @return
     ***************************************************************/
    private int getRandomRoleId() {
        Random random = new Random();
        int randomInt = random.nextInt(this.rolesArray.length);
        log.info(String.format("MICK - Roles length = %s, Random key = %s",
            this.rolesArray.length, randomInt));
        return randomInt;
    }

}
