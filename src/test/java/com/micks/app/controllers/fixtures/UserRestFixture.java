/******************************************************************************
 * File: 			UserRestFixture.java
 * Created date:	Nov 26, 2013
 * Created time:	3:26:17 PM
 * User:			mick
 * Version :		1.0
 *****************************************************************************/
package com.micks.app.controllers.fixtures;


/******************************************************************************
 * Class description....
 * 
 * @author mick
 * @version 1.0
 *****************************************************************************/
public class UserRestFixture {

    private static String existingUser = 
        "\"user\" : { "
        + "\"id\" : 3, "
        + "\"name\" : \"minkey bule\" } ";
     
    private static String testUser = 
        "{ "
        + "\"id\" : 3, "
        + "\"name\" : \"minkey bule\" } ";
     
    /************************************************************************
    * Method description...
    *
    * @return
    *************************************************************************/
    public static String getDefaultUser() {
        return testUser;
    }
    
}
