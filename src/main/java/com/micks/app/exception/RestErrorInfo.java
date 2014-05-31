/******************************************************************************
 * File: 			RestErrorInfo.java
 * Created date:	Nov 28, 2013
 * Created time:	9:00:12 AM
 * User:			mick
 * Version :		1.0
 *****************************************************************************/
package com.micks.app.exception;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/******************************************************************************
 * Class description....
 * 
 * @author mick
 * @version 1.0
 *****************************************************************************/
@XmlRootElement
@XmlType(name = "restErrorInfo", propOrder = {"url", "errorMessage"})
public class RestErrorInfo {

    @XmlElement
    private final String url;

    @XmlElement
    private final String errorMessage;

    /************************************************************************
     * Constructor description...
     *	    
     *************************************************************************/
    public RestErrorInfo() {
        this.url = "not set";
        this.errorMessage = "not set";
    }
    
    /************************************************************************
     * Constructor description...
     *
     * @param url
     * @param ex	    
     *************************************************************************/
    public RestErrorInfo(String url, Exception ex) {
        this.url = url;
        
        String msg = String.format("%s : %s", ex.getClass().getSimpleName(),
                ex.getLocalizedMessage());
        this.errorMessage = msg;
    }

    /************************************************************************
    * Method description...
    *
    * @return
    *************************************************************************/
    public String getUrl() {
        return this.url;
    }

    /************************************************************************
    * Method description...
    *
    * @return
    *************************************************************************/
    public String getErrorMessage() {
        return this.errorMessage;
    }

    /************************************************************************
     * Method description... 
     *
     * @return
     *************************************************************************/
    @Override
    public String toString() {
        return "RestErrorInfo [url=" + url + ", errorMessage=" + errorMessage
                + "]";
    }
}
