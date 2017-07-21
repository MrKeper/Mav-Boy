public class Player extends Employee implements Proj3Interface
{
    private final Date dateHired;
    private double baseSalary;
    private double performanceBouns;
    private String type = "Player";
    
    public Player(String first, String last, String gen, String dob, String joinDate, double salary,double bonus)
    {
        setEmployeeID();
        setFirstName(first);
        setLastName(last);
        setGender(gen);
        setDOB(dob);
        dateHired = new Date(joinDate);
        baseSalary = salary;
        performanceBouns = bonus;
    }
    
    @Override
     public String toString()
    {
            return "Employee ID: "+getEmployeeID()+" | Name: "+getFirstName()+" "+getLastName()+" | Gender: "+getGender()+" | DOB: "+getDateOfBirth()+" | Date Hired: "+dateHired+" | Salary: "+baseSalary+" | Performance Bonus: "+performanceBouns;         
    }
     
    
     public double getSalary()
     {
         return baseSalary;
     }
     
     public double getBonus()
     {
         return performanceBouns;
     }
     
    /**
     *Returns the  salary
     * @param salayParameter
     * @return
     */
    @Override
     public int getAge()
     {
         int age = 0;
         return age;
     }
     
    @Override
    public double computeSalary(int salayParameter)
    {
        double salary = baseSalary + (performanceBouns*salayParameter);
        return salary;
    }
    
    public Date getDateHired()
     {
         return dateHired;
     }
    
    public static void main(String args[])
    {
        //Employee p1 = new Player("Test","9-1-2012");
        //System.out.println(p1.getFirstName());
        
    }
    
    public String getType()
    {
        return type;
    }
}