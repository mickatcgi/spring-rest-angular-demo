/**
 * 
 */
package com.micks.model;

import java.util.ArrayList;
import java.util.List;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
public class WorkItem {

    private final long id;
    private final String name = "WorkItem";
    private final List<String> myStuff = new ArrayList<>();
    
    /***************************************************************
     * 
     ***************************************************************/
    public WorkItem(long id) {
        this.id = id;
    }

    /***************************************************************
     * @return
     ***************************************************************/
    public List<String> getMyStuff() {
        for(int x = 0; x < 5; x++) {
            String s = String.format("Workitem list stuff #%s", x);
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
    
    public String getName() {
        return this.name;
    }
}
