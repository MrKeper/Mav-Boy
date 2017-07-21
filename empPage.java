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
public class empPage extends JFrame 
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JButton backButton;
    private JPanel employeePanel;
    private JScrollPane scrollPane;
    
    
    public empPage(Enterprise e)
    {
        myEnterprise = e;
        setTitle("MavBoy Enterprise's Employee List");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildEmployeePanel();
        scrollPane = new JScrollPane(employeePanel);
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
        JTextPane empInfo;
        Enterprise tempEnt = getEnterprise();
        Employee tempEmp = tempEnt.getEmployees().get(0);
        employeePanel = new JPanel();
        employeePanel.setBackground(Color.WHITE);
        employeePanel.setLayout(new GridLayout(tempEnt.getEmployees().size(),1));
        empInfo = new JTextPane();
        for(int i = 0; i < tempEnt.getEmployees().size();i++)
        { 
            empInfo = new JTextPane();
            empInfo.setText(tempEnt.getEmployees().get(i).toString());
            empInfo.setFont(new Font("SansSerif", Font.PLAIN, 15));
            employeePanel.add(empInfo);
            tempEmp = tempEnt.getEmployees().get(i);
            
        }
        empInfo.setEditable(false);
    }
    
    public static void main(String[] args)
    {
        Enterprise ent = new Enterprise("mavBoy");
        empPage emp = new empPage(ent);
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
