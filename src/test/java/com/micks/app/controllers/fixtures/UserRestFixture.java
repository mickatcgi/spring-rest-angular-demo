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
        + "\"firstName\" : \"FullMinkey\", "
        + "\"lastName\" : \"FullBule\" , "
        + "\"role\" : { \"id\" : 0 , \"description\" : \"Member\" } "
        + " } ";
     
    private static String testUser = 
        "{ "
        + "\"id\" : 3, "
        + "\"firstName\" : \"TestMinkey\", "
        + "\"lastName\" : \"TestBule\", "
        + "\"role\" : { \"id\" : 0 , \"description\" : \"Member\" } "
        + " } ";
    
    /************************************************************************
    * Method description...
    *
    * @return
    *************************************************************************/
    public static String getDefaultUser() {
        return testUser;
    }
    
}


