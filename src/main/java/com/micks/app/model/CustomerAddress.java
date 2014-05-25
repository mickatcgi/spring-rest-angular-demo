/**
 * 
 */
package com.micks.app.model;

/***************************************************************
 * @author mick
 *
 ***************************************************************/
public class CustomerAddress {

    private final long id;
    private String addrLine1;
    private String addrLine2;
    private String city;
    private String state;
    private String zip;

    /***************************************************************
     * 
     ***************************************************************/
    public CustomerAddress(long id) {
        this.id = id;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String
            .format(
                "CustomerAddress [id=%s, addrLine1=%s, addrLine2=%s, city=%s, state=%s, zip=%s]",
                id, addrLine1, addrLine2, city, state, zip);
    }

}
