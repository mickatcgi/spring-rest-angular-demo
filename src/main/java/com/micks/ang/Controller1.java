/**
 * 
 */
package com.micks.ang;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public @ResponseBody Greeting getStuff(
        @RequestParam(value = "name", 
        required = false, 
        defaultValue = "Toerag") String name) {

        Date today = new Date();
        Greeting g = new Greeting(
            counter.incrementAndGet(),
            String.format("Controller1: %s on %s", name, today));

        return g;
    }

}
