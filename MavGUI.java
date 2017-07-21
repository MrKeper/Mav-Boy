
/**
 *
 * @author Keenan
 */
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class MavGUI extends JFrame
{
    
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JPanel panelC; 
    private JPanel panelW;
    private JPanel panelS;
    private JLabel messageLabel; 
    private JButton items;
    private JButton employees;
    private JButton customers;
    private Enterprise myEnterprise;


        
    /*public MavGUI()
    {
        setTitle("MavBoy Enterprise");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildWestPanel();
        buildCenterPanel();
        buildSouthPanel();
        add(panelW,BorderLayout.WEST);
        add(panelC,BorderLayout.CENTER);
        add(panelS,BorderLayout.SOUTH);
        setVisible(true);
    }*/
    
    /**
     * GUI class that uses JFrame, Border Layout, JPanel, JLabel,
     * JButton, Grid Layout, JOptionPsne(from classes created in this class (e.g InputYearRev))
     * JScrollPane, and JTextPane
     * @param e 
     */
    public MavGUI(Enterprise e)
    {
        myEnterprise = e;
        setTitle("MavBoy Enterprise");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildWestPanel();
        buildCenterPanel();
        buildSouthPanel();
        add(panelW,BorderLayout.WEST);
        add(panelC,BorderLayout.CENTER);
        add(panelS,BorderLayout.SOUTH);
        setVisible(true);
    }
    
    private void buildCenterPanel()
    {
        messageLabel = new JLabel("Welcome to MavBoy Enterprises");
        messageLabel.setFont(new Font("SansSerif", Font.PLAIN, 45));
        panelC = new JPanel();
        panelC.add(messageLabel);
        panelC.setBackground(Color.WHITE);
    }
    
    private void buildSouthPanel()
    {
        JButton actionButton1 = new JButton("Longest Working Employee(s)");
        JButton actionButton2 = new JButton("Best/Worst Customers");
        JButton actionButton3 = new JButton("Item Sales");
        JButton actionButton4 = new JButton("Total Revenues");
        JButton actionButton5 = new JButton("Purchase Details");
        JButton actionButton6 = new JButton("Exit");
        
        actionButton1.addActionListener(new actionButton1());
        actionButton2.addActionListener(new actionButton2());
        actionButton3.addActionListener(new actionButton3());
        actionButton4.addActionListener(new actionButton4());
        actionButton5.addActionListener(new actionButton5());
        
        actionButton1.setBackground(Color.WHITE);
        actionButton1.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        actionButton2.setBackground(Color.WHITE);
        actionButton2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        
        actionButton3.setBackground(Color.WHITE);
        actionButton3.setFont(new Font("SansSerif", Font.PLAIN, 15));
        
        actionButton5.setBackground(Color.WHITE);
        actionButton5.setFont(new Font("SansSerif", Font.PLAIN, 15));
        
        actionButton4.setBackground(Color.WHITE);
        actionButton4.setFont(new Font("SansSerif", Font.PLAIN, 15));
        
        actionButton6.setBackground(Color.WHITE);
        actionButton6.setFont(new Font("SansSerif", Font.PLAIN, 25));
        actionButton6.addActionListener(new exitButtonListener());
        
        panelS = new JPanel();
        panelS.setLayout(new GridLayout(1, 6));
        panelS.add(actionButton1);
        panelS.add(actionButton2);
        panelS.add(actionButton3);
        panelS.add(actionButton4);
        panelS.add(actionButton5);
        panelS.add(actionButton6);
        panelS.setBackground(Color.WHITE);
    }
    
    private void buildWestPanel()
    {
        items = new JButton("Items");
        employees = new JButton("Employees");
        customers = new JButton("Customers");
        
        employees.addActionListener(new empButtonListener());
        items.addActionListener(new itemButtonListener());
        customers.addActionListener(new cusButtonListener());
        
        items.setBackground(Color.WHITE);
        employees.setBackground(Color.WHITE);
        customers.setBackground(Color.WHITE);
        
        employees.setFont(new Font("SansSerif", Font.PLAIN, 25));
        items.setFont(new Font("SansSerif", Font.PLAIN, 25));
        customers.setFont(new Font("SansSerif", Font.PLAIN, 25));
        
        panelW = new JPanel();
        panelW.setLayout(new GridLayout(3, 1));
        panelW.add(employees);
        panelW.add(items);
        panelW.add(customers);
        panelW.setBackground(Color.WHITE);
    }
    
     private class empButtonListener implements ActionListener
     {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             Enterprise tempEnt = getEnterprise();
             empPage tempEmpPage = new empPage(tempEnt);
        }
     }
     
     private class itemButtonListener implements ActionListener
     {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             Enterprise tempEnt = getEnterprise();
             itemPage tempItemPage = new itemPage(tempEnt);
         }

     }
     
      private class exitButtonListener implements ActionListener
     {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             System.exit(0);
         }

     }
     
     private class cusButtonListener implements ActionListener
     {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             Enterprise tempEnt = getEnterprise();
             CusPage tempCusPage = new CusPage(tempEnt);
         }

     }
     
      private class actionButton1 implements ActionListener//Longest Working Employee(s)
     {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             Enterprise tempEnt = getEnterprise();
             LongWorkEmpPage lwe = new LongWorkEmpPage(tempEnt);
         }

     }
      
     private class actionButton2 implements ActionListener//Best/Worst Customers
     {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             Enterprise tempEnt = getEnterprise();
             BestWorstCustomers bwc = new BestWorstCustomers(tempEnt);
         }

     }
            
    private class actionButton3 implements ActionListener//Item Sales
     {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             Enterprise tempEnt = getEnterprise();
             ItemsSold is = new ItemsSold(tempEnt);
         }

     }
                  
     private class actionButton4 implements ActionListener//Total Revenues
     {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             Enterprise tempEnt = getEnterprise();
             InputYearRev iyr = new InputYearRev(tempEnt);
         }

     }
                        
     private class actionButton5 implements ActionListener//Purchase Details
     {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             Enterprise tempEnt = getEnterprise();
             PurchaseDetails pd = new PurchaseDetails(tempEnt);
         }

     }
     
     public Enterprise getEnterprise()
     {
         return myEnterprise;
     }
     
    public static void main(String [] args)
    {
        int w = 4;
        System.out.println(w);
    }
}
