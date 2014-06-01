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
    private String name;

    /***************************************************************
     * 
     ***************************************************************/
    public User() {
        this(0, null);
    }
    
    /***************************************************************
     * 
     ***************************************************************/
    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s]", id, name);
    }

}
