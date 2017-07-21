/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Keenan
 */
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class PurchaseDetails extends JFrame
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JButton backButton;
    private JPanel customerPanel;
    private JScrollPane scrollPane;
    private JButton customerInfo;
    
    public PurchaseDetails(Enterprise e)
    {
        myEnterprise = e;
        setTitle("MavBoy Enterprise's Item List");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildCustomerPanel();
        scrollPane = new JScrollPane(customerPanel);
        add(backButton,BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);
        setVisible(true);
    }
    
    public void buildBackButton()
    {
        backButton = new JButton("Back to Main Page");
        backButton.addActionListener(new backButtonListener());
        backButton.setBackground(Color.WHITE);
        backButton.setFont(new Font("SansSerif", Font.PLAIN, 25));
    }
    
    public void buildCustomerPanel()
    {
        Enterprise tempEnt = getEnterprise();
        Customer tempCustomer = tempEnt.getCustomers().get(0);
        customerPanel = new JPanel();
        customerPanel.setBackground(Color.WHITE);
        customerPanel.setLayout(new GridLayout(tempEnt.getCustomers().size(),1));
        for(int i = 0; i < tempEnt.getCustomers().size();i++)
        { 
            customerInfo = new JButton(tempEnt.getCustomers().get(i).getCustomerID()+" "+tempEnt.getCustomers().get(i).getFirstName()+" "+tempEnt.getCustomers().get(i).getLastName());
            customerInfo.setFont(new Font("SansSerif", Font.PLAIN, 15));
            customerInfo.setBackground(Color.WHITE);
            customerInfo.addActionListener(new customerButtonListener(tempEnt.getCustomers().get(i).getCustomerID()));
            customerPanel.add(customerInfo);
        }
    }
    
    private class customerButtonListener implements ActionListener
    {
        private int customerID;
        public customerButtonListener(int id)
        {
            customerID = id;
        }
         @Override
         public void actionPerformed(ActionEvent emp)
         {
            PurchaseDetailsYear pdy = new PurchaseDetailsYear(myEnterprise,customerID);
            dispose();
         }

    }
    
    public static void main(String[] args)
    {
        Enterprise ent = new Enterprise("mavBoy");
        itemPage i = new itemPage(ent);
    }
    
    private class backButtonListener implements ActionListener
    {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             dispose();
         }

    }
    
    public Enterprise getEnterprise()
    {
        return myEnterprise;
    }
}
