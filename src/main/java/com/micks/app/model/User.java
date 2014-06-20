/**
 * 
 */
package com.micks.app.model;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private boolean enabled;

    /***************************************************************
     * 
     ***************************************************************/
    public User() {
        this(0, "Billbob", "McDoofenschmirtz", true);
    }
    
    /***************************************************************
     * 
     ***************************************************************/
    public User(long id, String firstName, String lastName, boolean enabled) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return String.format(
            "User [id=%s, firstName=%s, lastName=%s, enabled=%s]", id,
            firstName, lastName, enabled);
    }

}
