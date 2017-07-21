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
public class LongWorkEmpPage extends JFrame
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JButton backButton;
    private JPanel lwePanel;
    private JScrollPane scrollPane;
    
    public LongWorkEmpPage(Enterprise e)
    {
        myEnterprise = e;
        setTitle("MavBoy Enterprise's Item List");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildLWEPanel();
        scrollPane = new JScrollPane(lwePanel);
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
    
    public void buildLWEPanel()
    {
        JTextPane lweInfo;
        Enterprise tempEnt = getEnterprise();
        Employee tempEmp = tempEnt.getEmployees().get(0);
        Date oldest = tempEmp.getDateHired();
        lwePanel = new JPanel();
        lwePanel.setBackground(Color.WHITE);
        lwePanel.setLayout(new GridLayout(tempEnt.getEmployees().size(),1));
        lweInfo = new JTextPane();
        for(int i = 0; i < tempEnt.getEmployees().size();i++)
        { 
            tempEmp = tempEnt.getEmployees().get(i);
            if(tempEmp.getDateHired().isBefore(oldest))
            {
                oldest = tempEmp.getDateHired();
            }
        }
        lweInfo = new JTextPane();
        lweInfo.setText("Longest Working Employee(s):");
        lweInfo.setFont(new Font("SansSerif", Font.PLAIN, 25));
        lwePanel.add(lweInfo);
        for(int i = 0; i < tempEnt.getEmployees().size();i++)
        {
             tempEmp = tempEnt.getEmployees().get(i);
            if(tempEmp.getDateHired().daysBetween(oldest) == 0)
            {
                lweInfo = new JTextPane();
                lweInfo.setText(tempEnt.getEmployees().get(i).toString());
                lweInfo.setFont(new Font("SansSerif", Font.PLAIN, 15));
                lwePanel.add(lweInfo);
            }
        }
        lweInfo.setEditable(false);
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
