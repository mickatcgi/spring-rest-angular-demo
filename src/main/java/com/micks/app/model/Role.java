/***************************************************************
 * File:		Role.java
 * Class:		Role
 * Author:		mick
 * Created:		Jun 19, 2014 : 6:48:29 PM
 ***************************************************************/
package com.micks.app.model;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
public class Role {
    
    private long id;
    private String description;

    /***************************************************************
     * 
     ***************************************************************/
    public Role() {
    }

    /***************************************************************
     * 
     ***************************************************************/
    public Role(long id, String description) {
        this.id = id;
        this.description = description;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return String.format("Role [id=%s, description=%s]", id, description);
    }

}
