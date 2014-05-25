/**
 * 
 */
package com.micks.app.model;

import java.util.ArrayList;
import java.util.List;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
public class Customer {

    private final long id;
    private final String name = "Customer";
    private List<String> myStuff = new ArrayList<>();
    
    /***************************************************************
     * 
     ***************************************************************/
    public Customer(long id) {
        this.id = id;
    }

    /***************************************************************
     * @return
     ***************************************************************/
    public List<String> getMyStuff() {
        for(int x = 0; x < 5; x++) {
            String s = String.format("Customer list stuff #%s", x);
            myStuff.add(s);
        }
        return this.myStuff;
    }

    /***************************************************************
     * @return
     ***************************************************************/
    public long getId() {
        return id;
    }

    /***************************************************************
     * @return
     ***************************************************************/
    public String getName() {
        return this.name;
    }

    /***************************************************************
       (non-Javadoc)
     * @see java.lang.Object#toString()
     ***************************************************************/
    @Override
    public String toString() {
        return String.format("Customer [id=%s, name=%s, myStuff=%s]", id, name,
            myStuff.toString());
    }
}
