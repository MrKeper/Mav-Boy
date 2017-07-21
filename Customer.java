
import java.util.*;
        
public class Customer
{
    private int customerID;
    private String firstName;
    private String lastName;
    private String gender;
    private final Date dateOfBirth;
    private String customerType;
    private final Date firstPurchaseDate;
    private Address customerAddress;
    private ArrayList<Transaction> purchaseList;
    private double totalSpent = 0;
    
    /**
     * Constructor with Date objects passed in for the dates instead of Strings
     * @param id
     * @param first
     * @param last
     * @param gen
     * @param dob
     * @param type
     * @param firstPurchase
     * @param houseNum
     * @param street
     * @param city
     * @param state 
     */
    public Customer(int id, String first, String last, String gen, Date dob, String type, Date firstPurchase, String houseNum ,String street, String city, String state)
    {
        customerID = id;
        firstName = first;
        lastName = last;
        gender = gen;
        dateOfBirth = dob;
        customerType = type;
        firstPurchaseDate = firstPurchase;
        customerAddress = new Address(houseNum,street,city,state);
        purchaseList = new ArrayList<Transaction>();
    }
    /**
     * Constructor with Date objects passed in as Strings
     * @param id
     * @param first
     * @param last
     * @param gen
     * @param dob
     * @param type
     * @param firstPurchase
     * @param houseNum
     * @param street
     * @param city
     * @param state 
     */
    public Customer(int id, String first, String last, String gen, String dob, String type, String firstPurchase, String houseNum ,String street, String city, String state)
    {
        customerID = id;
        firstName = first;
        lastName = last;
        gender = gen;
        dateOfBirth = new Date(dob);
        customerType = type;
        firstPurchaseDate = new Date(firstPurchase);
        customerAddress = new Address(houseNum,street,city,state);
        purchaseList = new ArrayList<Transaction>();
    }

    /**
     * toString method for the Customer class
     * @return 
     */
    public String toString()
    {
        return "Customer ID: "+customerID+"| First Name: "+firstName+"| Last Name: "+lastName+"| Gender: "+gender+"| DOB: "+dateOfBirth+"| Customer Type: "+customerType+"| Date of first purchase: "+firstPurchaseDate+" Customer Address: "+customerAddress.toString();
    }
    
    public static void main(String[] args)
    {
        
    }
    /**
     * Prints the transactions that the customer object has in its purchaseList Array
     */
    public void listPurchaseList()
    {
        int i;
        Item tempItem;
        for(i = 0; i < purchaseList.size(); i++)
        {
            tempItem = purchaseList.get(i).getPurchasedItem();
            if("ticketing".equals(tempItem.getItemDepartment()))//"ticketing" "merchandise"
            {
                System.out.println("|Purchase Date: "+purchaseList.get(i).getPurchaseDate()+"| Item ID: "+tempItem.getItemId()+"| Item Name: "+tempItem.getItemName()+" | Item Type: "+tempItem.getItemType()+" | Item Quanity: "+purchaseList.get(i).getQunaityOfPurchase()+" | Cost of Transaction: "+purchaseList.get(i).getTransactionCost());
            }
            if("merchandise".equals(tempItem.getItemDepartment()))//"ticketing" "merchandise"
            {
                System.out.println("|Purchase Date: "+purchaseList.get(i).getPurchaseDate()+"| Item ID: "+tempItem.getItemId()+"| Item Name: "+tempItem.getItemName()+" | Item Size: "+tempItem.getItemSize()+" | Item Quanity: "+purchaseList.get(i).getQunaityOfPurchase()+" | Cost of Transaction: "+purchaseList.get(i).getTransactionCost());
            }
            
            
        }
    }
    public void addTransaction(Transaction newTransaction)
    {
        purchaseList.add(newTransaction);
    }
    
    public int getCustomerID()
    {
        return customerID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public Date getDateOfBirth()
    {
           return dateOfBirth;
    }
    
    public String getCustomerType()
    {
        return customerType;
    }
    
    public Date getFirstPurchaseDate()
    {
        return firstPurchaseDate;
    }
    
    public Address getCustomerAddress()
    {
        return customerAddress;
    }
    
    public double getTotalSpent()
    {
        return totalSpent;
    }
    
    public ArrayList<Transaction> getPurchaseList()
    {
        return purchaseList;
    }
    
    public String getCustomerState()
    {
        return customerAddress.getState();
    }
    
    public void setCustomerID(int newID)
    {
        customerID = newID;
    }
    
    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }
    
    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }
    
    public void setGender(String newGender)
    {
        gender = newGender;
    }
    
    public void setCustomerType(String newCustomerType)
    {
        customerType = newCustomerType;
    }
    
    public void setCustomerAddress(Address newAddress)
    {
        customerAddress = newAddress;
    }
    
    public void setTotalSpent(double newTotalSpent)
    {
        totalSpent = newTotalSpent;
    }
    
    public void updateCustomerType(double moneySpent)
    {
        if(moneySpent > 5000)
            customerType = "GOLD";
        else
            customerType = "REGULAR";
    }
    
    public void retainCustomerType(String year)
    {
        int i;
        int yearlyExpenditure = 0;
        Transaction tempTransaction;
        Date tempDate = new Date(year);
        for(i =0; i < purchaseList.size(); i++)
        {
            tempTransaction = purchaseList.get(i);
            if(tempTransaction.getPurchaseDate() == tempDate)
            {
                yearlyExpenditure += tempTransaction.getTransactionCost();
            }
        }
        updateCustomerType(yearlyExpenditure);
    }
}