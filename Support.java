public class Support extends Employee implements Proj3Interface
{
    private final Date dateHired;
    private double baseSalary;
    private double hourlyOvertimeRate;
    private String type = "Support";
    
    public Support(String first, String last, String gen, String dob, String joinDate, double salary,double overtimeRate)
    {
        setEmployeeID();
        setFirstName(first);
        setLastName(last);
        setGender(gen);
        setDOB(dob);
        dateHired = new Date(joinDate);
        baseSalary = salary;
        hourlyOvertimeRate = overtimeRate;
    }
    
     @Override
     public int getAge()
     {
         int age = 0;
         return age;
     }
    
     @Override
     public String toString()
    {
            return "Employee ID: "+getEmployeeID()+" | Name: "+getFirstName()+" "+getLastName()+" | Gender: "+getGender()+" | DOB: "+getDateOfBirth()+" | Date Hired: "+dateHired+" | Salary: "+baseSalary+" | Overtime Rate: "+hourlyOvertimeRate;         
    }
    
     public double getOvertimeRate()
     {
         return hourlyOvertimeRate;
     }
     
    /**
     *Returns the  salary
     * @param salayParameter
     * @return
     */
    @Override
    public double computeSalary(int salayParameter)
    {
        double salary = baseSalary + (hourlyOvertimeRate*salayParameter);
        return salary;
    }
    
    public static void main(String args[])
    {
        
        
    }
    
    public Date getDateHired()
     {
         return dateHired;
     }
    
    public double getSalary()
     {
         return baseSalary;
     }
    
    public String getType()
    {
        return type;
    }
}