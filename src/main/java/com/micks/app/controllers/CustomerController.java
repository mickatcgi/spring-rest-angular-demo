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
import com.micks.app.model.CustomerAddress;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
@Controller
public class CustomerController {

    private Log log = LogFactory.getLog(CustomerController.class);

    private final AtomicLong custCounter = new AtomicLong();
    private final AtomicLong custAddressCounter = new AtomicLong();

    /***************************************************************
     * 
     ***************************************************************/
    @RequestMapping("/customer")
    public @ResponseBody Customer getStuff() {

        Customer c = new Customer(custCounter.incrementAndGet());

        this.log.info("MICK - Customer = " + c.toString());

        return c;
    }

    /***************************************************************
     * 
     ***************************************************************/
    @RequestMapping("/customerAddress")
    public @ResponseBody CustomerAddress getAddress() {

        CustomerAddress ca = new CustomerAddress(
            custAddressCounter.incrementAndGet());
        
        ca.setAddrLine1("9144 162nd PL NE");
        ca.setAddrLine2("Billybob Mall");
        ca.setCity("Redmond");
        ca.setState("Washington");
        ca.setZip("98052");

        this.log.info("MICK - CustomerAddress = " + ca.toString());

        return ca;
    }
}
