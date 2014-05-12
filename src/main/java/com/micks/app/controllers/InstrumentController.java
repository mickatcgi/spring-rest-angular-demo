package com.micks.app.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.micks.app.model.Instrument;
import com.micks.app.model.WorkItem;

@Controller
public class InstrumentController {

    private final AtomicLong counter = new AtomicLong();

    /***************************************************************
     * 
     ***************************************************************/
    @RequestMapping("/instrument")
    public @ResponseBody Instrument getStuff() {
        Instrument i = new Instrument(counter.incrementAndGet());
        return i;
    }

}