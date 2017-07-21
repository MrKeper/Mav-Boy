
/**
 *
 * @author Keenan
 */
public class Sales extends Employee implements Proj3Interface
{
    
    private final Date dateHired;
    private double hourlyRate;
    private String type = "Sales";
    
    /**
     *
     * @param first
     * @param last
     * @param gen
     * @param dob
     * @param joinDate
     * @param payRate
     */
    public Sales(String first, String last, String gen, String dob, String joinDate,double payRate)
    {
        setEmployeeID();
        setFirstName(first);
        setLastName(last);
        setGender(gen);
        setDOB(dob);
        dateHired = new Date(joinDate);
        hourlyRate = payRate;
    }
    
    /**
     *
     * @return
     */
    @Override
     public int getAge()
     {
         int age = 0;
         return age;
     }
    
     @Override
     public String toString()
    {
            return "Employee ID: "+getEmployeeID()+" | Name: "+getFirstName()+" "+getLastName()+" | Gender: "+getGender()+" | DOB: "+getDateOfBirth()+" | Date Hired: "+dateHired+" | Hourly Rate: "+hourlyRate;         
    }
     
    /**
     *Returns the  salary
     * @param salayParameter
     * @return
     */
    @Override
    public double computeSalary(int salayParameter)
    {
        double salary = (hourlyRate*salayParameter);
        return salary;
    }
    
    /**
     *
     * @param args
     */
    public static void main(String args[])
    {
        
        
    }
    
    /**
     *
     * @return
     */
    public Date getDateHired()
     {
         return dateHired;
     }
    
    /**
     *
     * @return
     */
    public double getHourlyRate()
     {
         return hourlyRate;
     }
    
    /**
     *
     * @return
     */
    public String getType()
    {
        return type;
    }
}


