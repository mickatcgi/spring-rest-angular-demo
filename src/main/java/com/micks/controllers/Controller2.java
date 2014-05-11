/**
 * 
 */
package com.micks.controllers;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.micks.model.Greeting;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
@Controller
public class Controller2 {

    private final AtomicLong counter = new AtomicLong();

    /***************************************************************
     * 
     ***************************************************************/
    @RequestMapping("/controller2")
    public @ResponseBody Greeting getStuff(
        @RequestParam(value = "name", 
        required = false, 
        defaultValue = "Doofenschmirtz") String name) {

        Date today = new Date();
        Greeting g = new Greeting(
            counter.incrementAndGet(),
            String.format("Controller2: %s on %s", name, today));

        return g;
    }

}
