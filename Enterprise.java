import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;
public class Enterprise
{
    private String enterpriseName;
    private double totalRevenue;
    private ArrayList<Employee> employees;
    private ArrayList<Item> items;
    private ArrayList<Customer> customers;
    private ArrayList<Transaction> transactions;
    /**
     * Constructor with just the name of the Enterprise
     * @param name 
     */
    public Enterprise(String name)
    {
        enterpriseName = name;
        totalRevenue = 0;
        employees = new ArrayList<Employee>();
        items = new ArrayList<Item>();
        customers = new ArrayList<Customer>();
        transactions = new ArrayList<Transaction>();
        
    }
    /**
     * Constructor with the and revenue of the Enterprise;
     * @param name
     * @param rev 
     */
    public Enterprise(String name, double  rev)
    {
        enterpriseName = name;
        totalRevenue = rev;
        employees = new ArrayList<Employee>();
        items = new ArrayList<Item>();
        customers = new ArrayList<Customer>();
        transactions = new ArrayList<Transaction>();

        
    }
    /**
     * Adds and Employee object to the employees ArrayList
     * @param first
     * @param last
     * @param gen
     * @param dob
     * @param aOS
     * @param joinDate
     * @param monthPay 
     */
    public void hireEmployee(String first, String last, String gen, String dob, String aOS, String joinDate, double salary, double rate)
    {
        if("PLAYER".equals(aOS))
        {
           Employee newPlayer = new Player(first,last,gen,dob,joinDate,salary,rate);
           employees.add(newPlayer);
           return;
        }
        if("SUPPORT".equals(aOS))
        {
            Employee newSupport = new Support(first,last,gen,dob,joinDate,salary,rate);
            employees.add(newSupport);
            return;
        }
            // Employee newEmployee = new Player( first,  last,  gen,  dob,  aOS,  joinDate,  monthPay);
        if("SALES".equals(aOS))
        {
            Employee newSales = new Sales(first,last,gen,dob,joinDate,rate);
            employees.add(newSales);
            return;
        }
        System.out.println("Error in hireEmployee input");
        return;
    }
    /**
     * Adds and Item object to the items ArrayList
     * @param id
     * @param name
     * @param department
     * @param price
     * @param size
     * @param type
     * @param quanity 
     */
    public void addItem(String id, String name, String department, double price, String size, String type, int quanity)
    {
        Item newItem = new Item( id,  name,  department,  price,  size,  type,  quanity);
        items.add(newItem);
    }
    /**
     * Adds and Customer object to the customer ArrayList
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
    public void addCustomer(int id, String first, String last, String gen, String dob, String type, String firstPurchase, String houseNum ,String street, String city, String state)
    {
        Customer newCustomer = new Customer( id,  first,  last,  gen,  dob,  type,  firstPurchase,  houseNum , street,  city,  state);
        customers.add(newCustomer);
    }
    

    public String getEnterpriseName()
    {
        return enterpriseName;
    }
    
    public double getTotalRevenue()
    {
        return totalRevenue;
    }
    
    public ArrayList<Employee> getEmployees()
    {
        return employees;
    }
    
    public ArrayList<Item> getItems()
    {
        return items;
    }
    
    public ArrayList<Customer> getCustomers()
    {
        return customers;
    }
    
    public void setEnterpriseName(String newName)
    {
        enterpriseName = newName;
    }
    
    public void setTotalRevenue(int newRevenue)
    {
        totalRevenue = newRevenue;
    }
    
    
    /**
     * Prints out Employee objects in the employee ArrayList
     */
    public void listEmployees()
    {
        int i;
        if(employees.isEmpty())
        {
            System.out.println("No employees are currently employed by "+enterpriseName);
            return;
        }
        for(i = 0; i < employees.size(); i++)
        {
            System.out.println(employees.get(i));
        }    
    }
    /**
     * Prints a single customer when a valid customer Id is entered and all if 0 is entered for the customer ID
     * @param ID 
     */
    public void listCustomersByID(int ID)
    {
        int i;
        Customer temp;
        if(customers.isEmpty())
        {
            System.out.println("There are currently no customers for the enterprise "+enterpriseName);
            return;
        }
        if(ID == 0)
        {
            for(i = 0; i < customers.size(); i++)
            {
                System.out.println(customers.get(i));
            }   
            return;
        }
        for(i = 0; i < customers.size(); i++)
        {
            temp = customers.get(i);
            if(temp.getCustomerID() == ID)
            {
                System.out.println(temp);
            }
        }    
        
    }
    /**
     * Prints a single customer when a valid state abbreviations is entered and all if * is entered for the stateName
     * @param stateName
     */
    public void listCustomersByState(String stateName)
    {
        int i;
        int printCount = 0;
        Customer temp;
        if(customers.isEmpty())
        {
            System.out.println("There are currently no customers for the enterprise "+enterpriseName);
            return;
        }
        
        if("*".equals(stateName))
        {
            for(i = 0; i < customers.size(); i++)
            {
                temp = customers.get(i);
                System.out.println(temp);
            
            }
            return;
        }
        
        for(i = 0; i < customers.size(); i++)
        {
            temp = customers.get(i);
            if(temp.getCustomerState().equals(stateName))
            {
                System.out.println(temp);
                printCount++;
            }
        }    
        if(printCount == 0)
            System.out.println("Either no customers from state entered or invlaid input");
    }
    
    /**
     * removes the employee with the id = to employeeID from the employees arraylist if the employeeID is valid
     * @param employeeID 
     */
    public void releaseEmployee(int employeeID)
    {
        int i;
        Employee temp;
        for(i = 0; i < employees.size(); i++)
        {
            temp = employees.get(i);
            if(temp.getEmployeeID() == employeeID)
            {
                System.out.println("Employee "+employeeID+" has been released from his/her postion.");
                employees.remove(i);
                return;
            }
        }
        System.out.println("There is no Employee "+employeeID+" currently employeed by "+enterpriseName);
    }
    
        
    public ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }
    
    /**
     * Adds transaction object to customer with specified Id  , subtracts quantity purchased from item specified, has specified sate, adds to total spent by customer and revenue of enterprise 
     * @param itemID
     * @param customerID
     * @param qunaity
     * @param date 
     */
    public void sellItem(String itemID, int customerID, int quantity, String date)
    {
        int i,existingItem=0;
        int tempCustomerID;
        int customerIndex = -1;
        Item tempItem = null;
        Customer tempCustomer = null;
        for(i = 0; i < items.size(); i++)
        {
            tempItem = items.get(i);
            if(itemID.equals(tempItem.getItemId()))
            {
                items.get(i).setItemQuanity( (items.get(i).getItemQuanity() - quantity) );
                existingItem = 1;
                break;
            }
        }

        for(i = 0; i < customers.size(); i++)
        {
            tempCustomer = customers.get(i);
            tempCustomerID = tempCustomer.getCustomerID();
            if(tempCustomerID == Integer.valueOf(customerID))
            {
                
                customerIndex = i;
                break;
            }
        }
        if(customerIndex == -1)
        {
            System.out.println("Customer Id not valid");
            return;
        }
        if(existingItem == 0)
        {
            System.out.println("Item ID not valid");
            return;
        }
        if(tempItem.getItemQuanity()  < Integer.valueOf(quantity))
        {
            System.out.println("Qunaity specified for purchase exceeds the current stock of the specified item");
            return;
        }
        Date transactionDate = new Date(date);
        double transactionPrice = (tempItem.getItemPrice() * quantity);
        if(tempCustomer.getCustomerType().equals("GOLD"))
        {
            transactionPrice = transactionPrice - (transactionPrice*.05);
        }
        Transaction newTranscation = new Transaction(tempItem, tempCustomer, transactionDate, quantity, transactionPrice );
        transactions.add(newTranscation);
        totalRevenue += transactionPrice;
        customers.get(i).setTotalSpent(customers.get(i).getTotalSpent() + transactionPrice);
    }
    /**
     * Adds transaction object to customer with specified Id  , subtracts quantity purchased from item specified, adds to total spent by customer and revenue of enterprise 
     * @param itemID
     * @param customerID
     * @param quantity 
     */
    public void sellItem(String itemID, int customerID, int quantity)
    {
        int i,existingItem=0;
        int tempCustomerID;
        int customerIndex = -1;
        Item tempItem = null;
        Customer tempCustomer = null;
        for(i = 0; i < items.size(); i++)
        {
            tempItem = items.get(i);
            if(itemID.equals(tempItem.getItemId()))
            {
                items.get(i).setItemQuanity( (items.get(i).getItemQuanity() - quantity) );
                existingItem = 1;
                break;
            }
        }
        for(i = 0; i < customers.size(); i++)
        {
            tempCustomer = customers.get(i);
            tempCustomerID = tempCustomer.getCustomerID();
           if(tempCustomerID == Integer.valueOf(customerID))
            {
                
                customerIndex = i;
                break;
            }
        }
        if(customerIndex == -1)
        {
            System.out.println("Customer Id not valid");
            return;
        }
        if(existingItem == 0)
        {
            System.out.println("Item ID not valid");
            return;
        }
        if(tempItem.getItemQuanity()  < Integer.valueOf(quantity))
        {
            System.out.println("Qunaity specified for purchase exceeds the current stock of the specified item");
            return;
        }
        Date today = new Date();
        double transactionPrice = (tempItem.getItemPrice() * quantity);
        if(tempCustomer.getCustomerType().equals("GOLD"))
        {
            transactionPrice = transactionPrice - (transactionPrice*.05);
        }
        Transaction newTranscation = new Transaction(tempItem, tempCustomer, today, quantity, transactionPrice );
        transactions.add(newTranscation);
        totalRevenue += transactionPrice;
        customers.get(i).setTotalSpent(customers.get(i).getTotalSpent() + transactionPrice);
    }
    /**
     * prints objects of item list, prints 10 at a time then prompts user for if they want to see more
     */
    public void listItems()
    {
        int i,count = 0;
        for(i = 0; i < items.size(); i++)
        {
            if(count == 10)
            {
                Scanner continuePrint = new Scanner(System.in);
                System.out.println("Do you want to look at more items: 1 for YES 0 for NO ");
                int n = continuePrint.nextInt();
                if(n == 0)
                    return;
                else
                    count = 0;
            }
            count++;
            System.out.println(items.get(i));
        }
    }
    /**
     * prints the id, first name, and last name of the customer with specified id and then prints the objects within the purchaseList arrayList in the customer object
     * @param customerID 
     */
    public void printCustomerPortfolio(int customerID)
    {
        int i,foundOnce=0;
        Customer tempCustomer;
        for(i = 0; i < transactions.size(); i++)
        {
            tempCustomer = transactions.get(i).getPurchaser();
            if(tempCustomer.getCustomerID() == customerID)
            {
                if(foundOnce == 0) System.out.println("\nCustomer: "+tempCustomer.getCustomerID()+ " "+tempCustomer.getFirstName()+" "+tempCustomer.getLastName());
                foundOnce = 1;
                System.out.println(transactions.get(i));
            }
        }
        if(foundOnce == 0)
        {
                    System.out.println("There is currently no customer with the id of "+customerID+" in the customer recordes of"+enterpriseName);
        }
    }
    
    public void printYearlyCustomerPortfolio(int customerID,String year)
    {
        int i,foundOnce=0;
        int y = Integer.parseInt(year);
        Customer tempCustomer;
        int transYear;
        for(i = 0; i < transactions.size(); i++)
        {
            tempCustomer = transactions.get(i).getPurchaser();
             transYear = transactions.get(i).getPurchaseDate().getYear();
            if(tempCustomer.getCustomerID() == customerID)
            {
                if(foundOnce == 0) System.out.println("\nCustomer: "+tempCustomer.getCustomerID()+ " "+tempCustomer.getFirstName()+" "+tempCustomer.getLastName());
                foundOnce = 1;
                if(y == transYear)
                {
                    System.out.println(transactions.get(i));
                }
            }
        }
        if(foundOnce == 0)
        {
                    System.out.println("There is currently no customer with the id of "+customerID+" in the customer recordes of"+enterpriseName);
        }
    }
    
    
    public void updateCustomerType(double moneySpent, int customerId)
    {
        int i;
        Customer tempCustomer; 
        for(i =0; i < customers.size(); i++)
        {
            tempCustomer = customers.get(i);
            if(tempCustomer.getCustomerID() == customerId)
            {
                if(moneySpent > 5000)
                {
                    customers.get(i).setCustomerType("GOLD");
                }
                else
                {
                    customers.get(i).setCustomerType("REGULAR");

                }
            }
        }
        
    }
    
    public void retainCustomerType(String year, String customerID)
    {
        int i,k,id=-1;
        int yearlyExpenditure = 0;
        if(!"*".equals(customerID))
        {
              id = Integer.parseInt(customerID);
        }
        Transaction tempTransaction;
        Customer tempCustomerA,tempCustomerB;
        int y; // y for years
        Date transactionDate;
        if("*".equals(customerID))
        {
            y  = Integer.parseInt(year);
            for(k=0;k < customers.size();k++)
            {
                yearlyExpenditure = 0;
                tempCustomerA = customers.get(k);
                for(i =0; i < transactions.size(); i++)
                {
                    tempTransaction = transactions.get(i);
                    tempCustomerB = tempTransaction.getPurchaser();
                    if(tempCustomerA.getCustomerID() == tempCustomerB.getCustomerID())
                    {
                        transactionDate = tempTransaction.getPurchaseDate();
                        if(transactionDate.getYear() == y)
                        {
                            yearlyExpenditure += tempTransaction.getTransactionCost();
                        }
                    }
                    
                }
                updateCustomerType(yearlyExpenditure,tempCustomerA.getCustomerID());
            }
            return;
        }
        y = Integer.parseInt(year);
        for(i =0; i < transactions.size(); i++)
        {
            tempTransaction = transactions.get(i);
            tempCustomerA = tempTransaction.getPurchaser();
            if(tempCustomerA.getCustomerID() == id)
            {
                transactionDate = tempTransaction.getPurchaseDate();
                if(transactionDate.getYear() == y)
                {
                    yearlyExpenditure += tempTransaction.getTransactionCost();
                }
            }
            
        }
        updateCustomerType(yearlyExpenditure,id);
    }
    /**
     * 
     * Prints the transactions that the item with specified id
     *String item id
     */
    public void itemPurchases(String itemId, PrintWriter output)
    {
        int i;
        Transaction tempTransaction;
        Item tempItem;
        for(i = 0; i < transactions.size(); i++)
        {
            tempItem = transactions.get(i).getPurchasedItem();
            if(tempItem.getItemId().equals(itemId))
            {
                
                output.println(transactions.get(i));
            }
        }
    }
    
    
    public void sellItemToFile(String itemID, int customerID, int quantity, String date, PrintWriter output)
    {
        int i,existingItem=0;
        int tempCustomerID;
        int customerIndex = -1;
        Item tempItem = null;
        Customer tempCustomer = null;
        for(i = 0; i < items.size(); i++)
        {
            tempItem = items.get(i);
            if(itemID.equals(tempItem.getItemId()))
            {
                items.get(i).setItemQuanity( (items.get(i).getItemQuanity() - quantity) );
                existingItem = 1;
                break;
            }
        }

        for(i = 0; i < customers.size(); i++)
        {
            tempCustomer = customers.get(i);
            tempCustomerID = tempCustomer.getCustomerID();
            if(tempCustomerID == Integer.valueOf(customerID))
            {
                
                customerIndex = i;
                break;
            }
        }
        if(customerIndex == -1)
        {
            output.println("Customer Id not valid");
            return;
        }
        if(existingItem == 0)
        {
            output.println("Item ID not valid");
            return;
        }
        if(tempItem.getItemQuanity()  < Integer.valueOf(quantity))
        {
            output.println("Quantity specified for purchase exceeds the current stock of the specified item");
            return;
        }
        Date transactionDate = new Date(date);
        double transactionPrice = (tempItem.getItemPrice() * quantity);
        if(tempCustomer.getCustomerType().equals("GOLD"))
        {
            transactionPrice = transactionPrice - (transactionPrice*.05);
        }
        Transaction newTranscation = new Transaction(tempItem, tempCustomer, transactionDate, quantity, transactionPrice );
        transactions.add(newTranscation);
        totalRevenue += transactionPrice;
        customers.get(i).setTotalSpent(customers.get(i).getTotalSpent() + transactionPrice);
        output.println("Client ID: "+customerID+" | Name: "+tempCustomer.getFirstName()+" "+tempCustomer.getLastName()+" | Item Name: "+tempItem.getItemName()+" | Purchase Date: "+transactionDate+" | Purchase Price: "+transactionPrice);
    }
    
    public void sellItemToFile(String itemID, int customerID, int quantity, PrintWriter output)
    {
        int i,existingItem=0;
        int tempCustomerID;
        int customerIndex = -1;
        Item tempItem = null;
        Customer tempCustomer = null;
        for(i = 0; i < items.size(); i++)
        {
            tempItem = items.get(i);
            if(itemID.equals(tempItem.getItemId()))
            {
                items.get(i).setItemQuanity( (items.get(i).getItemQuanity() - quantity) );
                existingItem = 1;
                break;
            }
        }

        for(i = 0; i < customers.size(); i++)
        {
            tempCustomer = customers.get(i);
            tempCustomerID = tempCustomer.getCustomerID();
            if(tempCustomerID == Integer.valueOf(customerID))
            {
                
                customerIndex = i;
                break;
            }
        }
        if(customerIndex == -1)
        {
            output.println("Customer Id not valid");
            return;
        }
        if(existingItem == 0)
        {
            output.println("Item ID not valid");
            return;
        }
        if(tempItem.getItemQuanity()  < Integer.valueOf(quantity))
        {
            output.println("Quantity specified for purchase exceeds the current stock of the specified item");
            return;
        }
        Date transactionDate = new Date();
       double transactionPrice = (tempItem.getItemPrice() * quantity);
        if(tempCustomer.getCustomerType().equals("GOLD"))
        {
            transactionPrice = transactionPrice - (transactionPrice*.05);
        }
        Transaction newTranscation = new Transaction(tempItem, tempCustomer, transactionDate, quantity, transactionPrice );
        transactions.add(newTranscation);
        totalRevenue += transactionPrice;
        customers.get(i).setTotalSpent(customers.get(i).getTotalSpent() + transactionPrice);
        output.println("Client ID: "+customerID+" | Name: "+tempCustomer.getFirstName()+" "+tempCustomer.getLastName()+" | Item Name: "+tempItem.getItemName()+" | Purchase Date: "+transactionDate+" | Purchase Price: "+transactionPrice);
    }
    
        public void printYearlyCustomerPortfolio(int customerID,String year,PrintWriter output)
    {
        int i,foundOnce=0;
        int y = Integer.parseInt(year);
        Customer tempCustomer;
        Item tempItem;
        int transYear;
        for(i = 0; i < transactions.size(); i++)
        {
            tempCustomer = transactions.get(i).getPurchaser();
            tempItem = transactions.get(i).getPurchasedItem();
            transYear = transactions.get(i).getPurchaseDate().getYear();
            if(tempCustomer.getCustomerID() == customerID)
            {
                if(foundOnce == 0) System.out.println("\nCustomer: "+tempCustomer.getCustomerID()+ " "+tempCustomer.getFirstName()+" "+tempCustomer.getLastName());
                foundOnce = 1;
                if(y == transYear)
                {
                    output.println("Item Id: "+tempItem.getItemId()+" | Item Name: "+tempItem.getItemName()+" | Purchase Date: "+transactions.get(i).getPurchaseDate()+" | Transaction Cost: "+transactions.get(i).getTransactionCost()+" | Customer Name: "+tempCustomer.getFirstName()+" "+tempCustomer.getLastName());
                }
            }
        }
        if(foundOnce == 0)
        {
                    System.out.println("There is currently no customer with the id of "+customerID+" in the customer recordes of"+enterpriseName);
        }
    }
    
     public void printCustomerPortfolioToFile(int customerID,PrintWriter output)
    {
        int i,foundOnce=0;
        Customer tempCustomer;
        Item tempItem;
        for(i = 0; i < transactions.size(); i++)
        {
            tempCustomer = transactions.get(i).getPurchaser();
            tempItem = transactions.get(i).getPurchasedItem();
            if(tempCustomer.getCustomerID() == customerID)
            {
                if(foundOnce == 0) System.out.println("\nCustomer: "+tempCustomer.getCustomerID()+ " "+tempCustomer.getFirstName()+" "+tempCustomer.getLastName());
                foundOnce = 1;
                output.println("Item Id: "+tempItem.getItemId()+" | Item Name: "+tempItem.getItemName()+" | Purchase Date: "+transactions.get(i).getPurchaseDate()+" | Transaction Cost: "+transactions.get(i).getTransactionCost()+" | Customer Name: "+tempCustomer.getFirstName()+" "+tempCustomer.getLastName());
            }
        }
        if(foundOnce == 0)
        {
                    output.println("There is currently no customer with the id of "+customerID+" in the customer recordes of"+enterpriseName);
        }
    }
     
     
     public void hireEmployee(String first, String last, String gen, String dob, String aOS, String joinDate, double salary, double rate,PrintWriter output)
    {
        if("PLAYER".equals(aOS))
        {
           Employee newPlayer = new Player(first,last,gen,dob,joinDate,salary,rate);
           employees.add(newPlayer);
           output.println("Newly Hired Employee: "+newPlayer);
           return;
        }
        if("SUPPORT".equals(aOS))
        {
            Employee newSupport = new Support(first,last,gen,dob,joinDate,salary,rate);
            employees.add(newSupport);
            output.println("Newly Hired Employee: "+newSupport);
            return;
        }
            // Employee newEmployee = new Player( first,  last,  gen,  dob,  aOS,  joinDate,  monthPay);
        if("SALES".equals(aOS))
        {
            Employee newSales = new Sales(first,last,gen,dob,joinDate,rate);
            employees.add(newSales);
            output.println("Newly Hired Employee: "+newSales);
            return;
        }
        output.println("Error in hireEmployee input");
        return;
    }
        
     
      public void listEmployeesToFile(PrintWriter output)
    {
        int i;
        if(employees.isEmpty())
        {
            output.println("No employees are currently employed by "+enterpriseName);
            return;
        }
        for(i = 0; i < employees.size(); i++)
        {
            output.println(employees.get(i));
        }    
    }
      

      
      
    public void payEmployee(int employeeID,int rate,PrintWriter output)
    {
        int i;
        double salary;
        Employee tempEmp;
        Date today = new Date();
        for(i=0;i<employees.size();i++)
        {
            tempEmp = employees.get(i);
            if(tempEmp.getEmployeeID() == employeeID)
            {
                salary = tempEmp.computeSalary(rate);
                output.println("Employee ID: "+tempEmp.getEmployeeID()+" | Employee Type: "+tempEmp.getType()+" | Employee Name: "+tempEmp.getFirstName()+" "+tempEmp.getLastName()+" | Gender: "+tempEmp.getGender()+" | Month: "+today.getMonthsArray()[today.getMonth()]+" | Salary: "+salary);
            }
        }
    }
    
    
    
    public void retainCustomerType2(int customerID, String year,PrintWriter output)
    {
        int i;
        int exist = 0;
        double yearlyExpenditure = 0;
        Transaction tempTransaction;
        Customer tempCustomer = null,printCustomer = null;
        int y; // y for years
        Date tempDate;
        y = Integer.parseInt(year);
        for(i=0;i<customers.size();i++)
        {
            if(customerID == customers.get(i).getCustomerID())
            {
                printCustomer = customers.get(i);
                exist = 1;
                break;
            }
        }
        if(exist == 0)
        {
            output.println(" Error Message from retainCustomerType2 : Customer "+customerID+" entered does not exist");
            return;
        }
        for(i = 0; i< transactions.size();i++)
        {
            tempTransaction = transactions.get(i);
            tempCustomer = tempTransaction.getPurchaser();
            tempDate = tempTransaction.getPurchaseDate();
            if(tempCustomer.getCustomerID() == customerID)
            {
                if(y == tempDate.getYear())
                {
                    yearlyExpenditure += tempTransaction.getTransactionCost();
                }
            }
        }
        updateCustomerType(yearlyExpenditure,customerID);
        output.println("Year: "+y+"\n"+" Customer ID: "+printCustomer.getCustomerID()+" | Customer Name: "+printCustomer.getFirstName()+" "+printCustomer.getLastName()+" | Expenditure for year: "+yearlyExpenditure+" | Customer Type: "+printCustomer.getCustomerType());
    }    
    
    
    public static void main(String[] args)
    {
       // /*  Testing Methods
        
        Employee p1 = new Player("Jim","Bob","male","9-1-2000","10-10-2020",25000,2500);
        Employee sale2 = new Sales("Sherly","Temple","female","9-1-1995","10-10-2010",250);
        Employee support3 = new Support("Jasmine","Temple","female","9-1-1995","10-10-2010",2000,160);
        Item i1 = new Item("1008","T-shirt","merchandise",25.34,"M","NA",25);
        Item i2 = new Item("38345","Ticket","ticketing",150.25,"NA","REGULAR",150);
        Customer c1 = new Customer(15486,"Kayte","Willaims","Female","9-1-1992","Regular","1-10-2015","4526","Martin Luther King Blvd","Arlington","TX");
        Customer c2 = new Customer(14558,"KaTyronyte","Jocanson","Male","5-1-1992","Regular","1-12-2015","1000","Martin Luther King Blvd","New york city","NY");
        Enterprise mavBoy = new Enterprise("MavBoys");
        mavBoy.employees.add(p1);
        mavBoy.employees.add(sale2);
        mavBoy.employees.add(support3);
        mavBoy.customers.add(c1);
        mavBoy.customers.add(c2);
        mavBoy.items.add(i1);
        mavBoy.items.add(i2);
        mavBoy.listEmployees();
        mavBoy.listItems();
        mavBoy.listCustomersByID(10001);
        mavBoy.listCustomersByState("NY");
        mavBoy.sellItem("1008",15486,5);
        mavBoy.sellItem("38345",14558,10);
        mavBoy.listItems();
        mavBoy.printCustomerPortfolio(15486);
        MavGUI window = new MavGUI(mavBoy); 
    }

}