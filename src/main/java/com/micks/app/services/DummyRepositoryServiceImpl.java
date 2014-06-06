/**
 * 
 */
package com.micks.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.micks.app.controllers.UserController;
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
    private AtomicLong nextAvailableId = new AtomicLong(0);

    // Use a map for easy insertion and retrieval - simulate a DB
    private Map<Long, User> userMap = new HashMap<>();

    // Seed the repository with dummy data.
    private String[][] userArray = {
        { "Billybob", "Thornton" },
        { "Jimbob", "Pitt" },
        { "Bobby sue", "Clinton" },
        { "Abraham", "Lincoln" },
        { "Jeremiah", "Bullfrog" }
    };

    /***************************************************************
     * 
     ***************************************************************/
    public DummyRepositoryServiceImpl() {
        this.initDummyUserList();
    }

    /***************************************************************
     * This DUMMY implementation hard-codes a list of users. We can replace this
     * repository impl with a real one later and leave the interface in place.
     ***************************************************************/
    public void initDummyUserList() {
        // Convert the string array to a HashMap for easy access
        for (String[] userNames : this.userArray) {
            Long id = this.nextAvailableId.getAndIncrement();
            User user = new User(id,
                userNames[0],
                userNames[1]);
            this.userMap.put(id, user);
        }
        log.info("MICK - Repository initializing dummy user list");
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
        long id = this.nextAvailableId.incrementAndGet();
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

}
