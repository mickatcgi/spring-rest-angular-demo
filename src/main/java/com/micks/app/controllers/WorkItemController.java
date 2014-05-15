/**
 * 
 */
package com.micks.app.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.micks.app.model.WorkItem;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
@Controller
public class WorkItemController {

    private Log log = LogFactory.getLog(WorkItemController.class);

    private final AtomicLong counter = new AtomicLong();

    /***************************************************************
     * 
     ***************************************************************/
    @RequestMapping("/workItem")
    public @ResponseBody WorkItem getStuff() {
        
        WorkItem w = new WorkItem(counter.incrementAndGet());

        this.log.info("MICK - WorkItem = " + w.toString());
        
        return w;
    }

}
