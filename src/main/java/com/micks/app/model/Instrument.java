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
public class Instrument {

    private final long id;
    private final String name = "Instrument";
    private final List<String> myStuff = new ArrayList<>();

    /***************************************************************
     * 
     ***************************************************************/
    public Instrument(long id) {
        this.id = id;
    }

    /***************************************************************
     * @return
     ***************************************************************/
    public List<String> getMyStuff() {
        myStuff.add("Cheese instrument 1111");
        myStuff.add("Bacon instrument 3333");
        myStuff.add("Guitar instrument 9999");
        myStuff.add("Piano instrument 4444");
        myStuff.add("Drums instrument 6666");

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
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     ***************************************************************/
    @Override
    public String toString() {
        return "Instrument [id=" + id + ", name=" + name + ", myStuff="
            + myStuff + "]";
    }
}
