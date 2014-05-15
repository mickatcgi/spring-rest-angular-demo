package com.micks.app.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.micks.app.model.Instrument;

@Controller
public class InstrumentController {

    private Log log = LogFactory.getLog(InstrumentController.class);

    private final AtomicLong counter = new AtomicLong();

    /***************************************************************
     * 
     ***************************************************************/
    @RequestMapping("/instrument")
    public @ResponseBody Instrument getStuff() {

        Instrument i = new Instrument(counter.incrementAndGet());

        this.log.info("MICK - Instrument = " + i.toString());

        return i;
    }

}