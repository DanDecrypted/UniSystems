/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package people;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Address implements java.io.Serializable {
    
    private String lineOne;
    private String lineTwo;
    private String city;
    private String county;
    private String postCode;
    
    public Address(){
        
    }
    
    /**
     * Constructor for the address objects 
     * @param lineOne first line of their address
     * @param lineTwo second line of their address
     * @param city city of the address to be created
     * @param county count of the address to be created
     * @param postCode post code of the address to be created
     */
    public Address(String lineOne, String lineTwo, String city, String county, String postCode) {
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
        this.city = city;
        this.county = county;
        this.postCode = postCode;
    }
    
    /**
     * Gets the address in a string format. 
     * @return string
     */
    public String getAddressString() {
        
        String address = lineOne;
        address += ", ";
        address += lineTwo;
        address += ", ";
        address += city;
        address += ", ";
        address += county;
        address += ", ";
        address += postCode;
        
        return address;
    }
}
