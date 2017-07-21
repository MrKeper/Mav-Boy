

public class Address
{
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    
    /**
     * 
     * @param houseNum
     * @param _street
     * @param _city
     * @param _state 
     * Constructor: using for Address
     */
    public Address(String houseNum,String _street, String _city, String _state)
    {
        houseNumber = houseNum;
        street = _street; 
        city = _city;
        state = _state;
    }
    
    /**
     * toString method for Address class
     * @return 
     */
    public String toString()
    {
        return houseNumber+" "+street+" "+city+" "+state;
    }
    
    /**
     * Method for changing the address of an Address object
     * @param newHouseNum
     * @param newStreet
     * @param newCity
     * @param newState 
     */
    public void changeAddress(String newHouseNum,String newStreet, String newCity, String newState)
    {
        houseNumber = newHouseNum;
        street = newStreet; 
        city = newCity;
        state = newState;
    }
    
    public static void main(String[] args)
    {
      Address home = new Address("2608", "Schwertner dr","Killeen","Texas") ;
      home.changeAddress("2600", "obliterare dr","houston","Africa");
      System.out.println(home.toString());
    }
    
     public String getHouseNumber()
    {
        return houseNumber;
    }
    
    public String getStreet()
    {
        return street;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getState()
    {
       return state; 
    }
    
    public void setHouseNumber(String newHouseNumber)
    {
        houseNumber = newHouseNumber;
    }
    
    public void setStreet(String newStreet)
    {
        street = newStreet;
    }
    
    public void setCity(String newCity)
    {
        city = newCity;
    }
    
    public void setState(String newState)
    {
        state = newState;
    }
    

}

