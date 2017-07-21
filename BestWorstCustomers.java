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
public class BestWorstCustomers extends JFrame
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JButton backButton;
    private JPanel bwcPanel;
    private JScrollPane scrollPane;
    
    public BestWorstCustomers(Enterprise e)
    {
        myEnterprise = e;
        setTitle("MavBoy Enterprise's Item List");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildLWEPanel();
        scrollPane = new JScrollPane(bwcPanel);
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
        JTextPane bwcInfo;
        Enterprise tempEnt = getEnterprise();
        Customer tempCustomer = tempEnt.getCustomers().get(0);
        Customer bestCustomer=null,worstCustomer=null;
        double highestSpent = 0,lowestSpent = Double.MAX_VALUE;
        bwcPanel = new JPanel();
        bwcPanel.setBackground(Color.WHITE);
        bwcPanel.setLayout(new GridLayout(tempEnt.getCustomers().size(),1));
        for(int i = 0; i < tempEnt.getCustomers().size();i++)
        { 
            tempCustomer = tempEnt.getCustomers().get(i);
            if(tempCustomer.getTotalSpent() > highestSpent)
            {
                highestSpent = tempCustomer.getTotalSpent();
                bestCustomer = tempCustomer;
            }
            if(tempCustomer.getTotalSpent() < lowestSpent)
            {
                lowestSpent = tempCustomer.getTotalSpent();
                worstCustomer = tempCustomer;
            }
        }
        if(bestCustomer != null && worstCustomer != null)
        {
            bwcInfo = new JTextPane();
            bwcInfo.setText("Best Customer(s): ");
            bwcInfo.setFont(new Font("SansSerif", Font.PLAIN, 25));
            bwcPanel.add(bwcInfo);
             for(int i = 0; i < tempEnt.getCustomers().size();i++)
             {
                 tempCustomer = tempEnt.getCustomers().get(i);
                 if(tempCustomer.getTotalSpent() == highestSpent)
                 {
                    bwcInfo = new JTextPane();
                    bwcInfo.setText(tempCustomer.toString() + "Amount Spent: " + highestSpent);
                    bwcInfo.setFont(new Font("SansSerif", Font.PLAIN, 13));
                    bwcPanel.add(bwcInfo);
                 }
             }
            
            
            bwcInfo = new JTextPane();
            bwcInfo.setText("Worst Customer(s): ");
            bwcInfo.setFont(new Font("SansSerif", Font.PLAIN, 25));
            bwcPanel.add(bwcInfo);
            for(int i = 0; i < tempEnt.getCustomers().size();i++)
             {
                 tempCustomer = tempEnt.getCustomers().get(i);
                 if(tempCustomer.getTotalSpent() == lowestSpent)
                 {
                    bwcInfo = new JTextPane();
                    bwcInfo.setText(tempCustomer.toString() + "Amount Spent: " + lowestSpent);
                    bwcInfo.setFont(new Font("SansSerif", Font.PLAIN, 13));
                    bwcPanel.add(bwcInfo);
                 }
             }
            bwcInfo.setEditable(false);
        }
        else
        {
            
        }
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
