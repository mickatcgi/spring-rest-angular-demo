package com.micks.controllers;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.micks.model.Greeting;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s! Today is %s";
    private final AtomicLong counter = new AtomicLong();

    /***************************************************************
     * @param name
     * @return
     ***************************************************************/
    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(
        @RequestParam(value = "name", required = false, defaultValue = "Billybob") String name) {

        Date today = new Date();
        Greeting g = new Greeting(
            counter.incrementAndGet(),
            String.format(template, name, today));

        return g;
    }
}