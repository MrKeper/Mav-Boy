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
public class InputYearRev extends JFrame
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 0; 
    private final int WINDOW_HEIGHT = 0; 
    private JButton backButton;
    private JOptionPane totalRevInYear;
    
    public InputYearRev(Enterprise e)
    {
        myEnterprise = e;
        setTitle("MavBoy Enterprise's Item List");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildTotalRevInYear();
        //add(backButton,BorderLayout.NORTH);
        //add(totalRevInYear,BorderLayout.CENTER);
        //setVisible(true);
        dispose();
    }
    
    public void buildTotalRevInYear()
    {
        totalRevInYear = new JOptionPane();
        totalRevInYear.setBackground(Color.WHITE);
        String inputYear = totalRevInYear.showInputDialog("Enter a year: ");
        
        try
        {
            int year = Integer.parseInt(inputYear);
            Date checkYear = new Date(year);
            if(year < 2000 || year > 2025)
            {
                totalRevInYear.showMessageDialog(null,"Invalid input for year","",totalRevInYear.ERROR_MESSAGE);
                return;
            }
            double revInYear = 0;
            Enterprise tempEnt = getEnterprise();
            for(int i = 0; i < tempEnt.getTransactions().size();i++)
            {
                Transaction tempTransaction = tempEnt.getTransactions().get(i);
                if(year == tempTransaction.getPurchaseDate().getYear())
                {
                    revInYear += tempTransaction.getTransactionCost();
                }
            }
            totalRevInYear.showMessageDialog(null,"Total revenue in " +year+" is "+revInYear);
        }
        catch(NumberFormatException nfe)
        {
            if(inputYear.equals("all"))
            {
                double revInYear = 0;
            Enterprise tempEnt = getEnterprise();
            for(int i = 0; i < tempEnt.getCustomers().size();i++)
            {
                revInYear += tempEnt.getCustomers().get(i).getTotalSpent();
            }
            totalRevInYear.showMessageDialog(null,"Total revenue in total is "+revInYear);
            }
            else
            {
                totalRevInYear.showMessageDialog(null,"Invalid input for year","",totalRevInYear.ERROR_MESSAGE);
            }
        }
    }
    
    public void buildBackButton()
    {
        backButton = new JButton("Back to Main Page");
        backButton.addActionListener(new backButtonListener());
        backButton.setBackground(Color.WHITE);
        backButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
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
