/**
 * 
 */
package com.micks.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.micks.model.Customer;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
@Controller
public class CustomerController {

    private final AtomicLong counter = new AtomicLong();

    /***************************************************************
     * 
     ***************************************************************/
    @RequestMapping("/customer")
    public @ResponseBody Customer getStuff() {

        Customer c = new Customer(counter.incrementAndGet());
        return c;
    }
}
