
package com.micks.app.model;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private Role role;
    private boolean enabled;

    /***************************************************************
     * 
     ***************************************************************/
    public User() {
        this(0, "Billbob", "McDoofenschmirtz", null, true);
    }
    
    /***************************************************************
     * 
     ***************************************************************/
    public User(long id, String firstName, String lastName, 
        Role role, boolean enabled) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format(
            "User [id=%s, firstName=%s, lastName=%s, role=%s, enabled=%s]", id,
            firstName, lastName, role, enabled);
    }

}
