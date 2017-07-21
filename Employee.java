public abstract class Employee
{
    private int employeeID;
    private static int idCount = 1;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String type;
   private  Date dateHired;

    public abstract int getAge();
    
    
    /**
     * Constructor with Date objects passed in as Strings
     * @param first
     * @param last
     * @param gen
     * @param dob
     * @param aOS
     * @param joinDate
     * @param monthPay 
     */
    /*
    public Employee(String first, String last, String gen, String dob, String aOS, String joinDate, double monthPay)
    {
        employeeID = idCount;
        idCount += 1;
        firstName = first;
        lastName = last;
        gender = gen;
        dateOfBirth = new Date(dob);
        areaOfSpecialization = aOS;
        dateJoined = new Date(joinDate);
        monthBasedSalary = monthPay;
    }
    
    /**
     * Constructor with Date objects passed in as dates
     * @param first
     * @param last
     * @param gen
     * @param dob
     * @param aOS
     * @param joinDate
     * @param monthPay 
     */
    /*
    public Employee(String first, String last, String gen, Date dob, String aOS, Date joinDate, double monthPay)
    {
        employeeID = idCount;
        idCount += 1;
        firstName = first;
        lastName = last;
        gender = gen;
        dateOfBirth = dob;
        areaOfSpecialization = aOS;
        dateJoined = joinDate;
        monthBasedSalary = monthPay;
    }
    
    /**
     * toString method for Employee method
     * @return 
     */
    
    public String toString()
    {
            return "Employee ID: "+employeeID+" | First Name: "+firstName+" | Last Name: "+lastName+" | Gender: "+gender+" | DOB: "+dateOfBirth;         
    }
    
    
    public static void main(String[] args)
    {
        
    }
    public abstract double computeSalary(int rate);
 
    public int getEmployeeID()
    {
        return employeeID;
    }
    
    public int getIdCount()
    {
        return idCount;
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
    
    
    public void setEmployee(int newID)
    {
        employeeID = newID;
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
    
    public void setDOB(String dob)
    {
        dateOfBirth = new Date(dob);
    }
    public void setEmployeeID()
    {
        employeeID = idCount;
        idCount += 1;
    }
    
    public String getType()
    {
        return type;
    }
      public Date getDateHired()
     {
         return dateHired;
     }
}