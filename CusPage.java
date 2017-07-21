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
public class CusPage extends JFrame
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JButton backButton;
    private JPanel customerPanel;
    private JScrollPane scrollPane;

    
    
    public CusPage(Enterprise e)
    {
        myEnterprise = e;
        setTitle("MavBoy Enterprise's Item List");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildEmployeePanel();
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
    
    public void buildEmployeePanel()
    {
        JTextPane customerInfo;
        Enterprise tempEnt = getEnterprise();
        Customer tempCustomer = tempEnt.getCustomers().get(0);
        customerPanel = new JPanel();
        customerPanel.setBackground(Color.WHITE);
        customerPanel.setLayout(new GridLayout(tempEnt.getCustomers().size(),1));
        customerInfo = new JTextPane();
        for(int i = 0; i < tempEnt.getCustomers().size();i++)
        { 
            customerInfo = new JTextPane();
            customerInfo.setText(tempEnt.getCustomers().get(i).toString());
            customerInfo.setFont(new Font("SansSerif", Font.PLAIN, 13));
            customerPanel.add(customerInfo);
            //tempCustomer = tempEnt.getCustomers().get(i);
            
        }
        customerInfo.setEditable(false);
    }
    
    public static void main(String[] args)
    {
        Enterprise ent = new Enterprise("mavBoy");
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
