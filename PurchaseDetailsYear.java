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
import java.util.Arrays;
public class PurchaseDetailsYear extends JFrame
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JButton backButton;
    private JPanel yearPanel;
    private JScrollPane scrollPane;
    private JButton year;
    private int customerID;
    
    public PurchaseDetailsYear(Enterprise e, int cusID)
    {
        myEnterprise = e;
        customerID = cusID;
        setTitle("MavBoy Enterprise's Item List");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildYearPanel();
        scrollPane = new JScrollPane(yearPanel);
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
    
    public void buildYearPanel()
    {
        Transaction tempTransaction;
        Customer tempCustomer;
        yearPanel = new JPanel();
        yearPanel.setBackground(Color.WHITE);
        yearPanel.setLayout(new GridLayout(myEnterprise.getTransactions().size(),1));
        int years[] = new int[myEnterprise.getTransactions().size()];
        Arrays.fill(years, -1);
        int check = 0;
        int y;
        int k =0;
        for(int i = 0; i < myEnterprise.getTransactions().size();i++)
        {
            tempTransaction = myEnterprise.getTransactions().get(i);
            y = tempTransaction.getPurchaseDate().getYear();
            for(int j = 0; j < myEnterprise.getTransactions().size();j++)
            {
                if(years[j] == y)
                {
                    check = 1;
                    break;
                }
            }
            if(check != 1)
            {
                years[k] = y;
                k++;
            }
            check = 0;
        }
        check = 0;
        for(int i = 0;i < years.length;i++)
        {
            if(years[i] != -1) check = 1;
        }
        if(check == 0)
        {
            JTextPane text = new JTextPane();
            text.setText("Customer has not made a purchase yet");
            text.setFont(new Font("SansSerif", Font.PLAIN, 25));
            yearPanel.add(text);
            return;
        }
        for(int i = 0;i < years.length;i++)
        {
            if( years[i] != -1)
            {
                year = new JButton(""+years[i]);
                year.setFont(new Font("SansSerif", Font.PLAIN, 15));
                year.setBackground(Color.WHITE);
                year.addActionListener(new yearButtonListener(years[i]));
                yearPanel.add(year);
            }
        }
    }
    
    
    private class yearButtonListener implements ActionListener
    {
        private int y;
        public yearButtonListener(int year)
        {
            y = year;
        }
         @Override
         public void actionPerformed(ActionEvent emp)
         {
            PurchaseDetailsInfo pdi = new PurchaseDetailsInfo(myEnterprise,customerID,y);
            dispose();
         }

    }
    
    private class backButtonListener implements ActionListener
    {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             dispose();
         }

    }
    
    
}
