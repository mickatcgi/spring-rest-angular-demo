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

import com.micks.app.model.Customer;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
@Controller
public class CustomerController {
    
    private Log log = LogFactory.getLog(CustomerController.class);

    private final AtomicLong counter = new AtomicLong();

    /***************************************************************
     * 
     ***************************************************************/
    @RequestMapping("/customer")
    public @ResponseBody Customer getStuff() {

        Customer c = new Customer(counter.incrementAndGet());
        
        this.log.info("MICK - Customer = %s" + c.toString());
        
        return c;
    }
}
