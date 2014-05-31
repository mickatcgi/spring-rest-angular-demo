/******************************************************************************
 * File: 			GlobalControllerExceptionHandler.java
 * Created date:	Nov 27, 2013
 * Created time:	4:06:30 PM
 * User:			mick
 * Version :		1.0
 *****************************************************************************/
package com.micks.app.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/******************************************************************************
 * Class description....
 * 
 * @author mick
 * @version 1.0
 *****************************************************************************/
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private Log log = LogFactory.getLog(GlobalControllerExceptionHandler.class);

    /************************************************************************
     * Method description...
     * 
     * @param req
     * @param ex
     * @return
     *************************************************************************/
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    RestErrorInfo handleBadRequest(HttpServletRequest req, Exception ex) {
        RestErrorInfo restErrorInfo = 
                new RestErrorInfo(req.getRequestURL().toString(), ex);
        log.error(restErrorInfo.toString());;
        //log.error(Utilities.getStackTrace(ex));
        return restErrorInfo;
    }
}
