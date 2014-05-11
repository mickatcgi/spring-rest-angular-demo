/**
 * 
 */
package com.micks.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.micks.model.WorkItem;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
@Controller
public class Controller1 {

    private final AtomicLong counter = new AtomicLong();

    /***************************************************************
     * 
     ***************************************************************/
    @RequestMapping("/controller1")
    public @ResponseBody WorkItem getStuff() {
        WorkItem w = new WorkItem(counter.incrementAndGet());
        return w;
    }

}
