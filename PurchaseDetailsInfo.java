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
public class PurchaseDetailsInfo extends JFrame
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JButton backButton;
    private JPanel purchasesPanel;
    private JScrollPane scrollPane;
    private int year;
    private int customerID;
    
    public PurchaseDetailsInfo(Enterprise e, int id, int y)
    {
        myEnterprise = e;
        customerID = id;
        year = y;
        setTitle("Purchase Info");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildPurchasesPanel();
        scrollPane = new JScrollPane(purchasesPanel);
        add(backButton,BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);
        setVisible(true);
    }
    
    public void buildPurchasesPanel()
    {
        Transaction tempTransaction;
        Customer tempCustomer;
        int y;
        JTextPane info;
        purchasesPanel = new JPanel();
        purchasesPanel.setBackground(Color.WHITE);
        purchasesPanel.setLayout(new GridLayout(myEnterprise.getTransactions().size()+1,1));
        info = new JTextPane();
        info.setText("Purchases Made:");
        info.setFont(new Font("SansSerif", Font.PLAIN, 25));
        purchasesPanel.add(info);
        int check = 0;
        for(int i = 0; i < myEnterprise.getTransactions().size();i++)
        {
            tempTransaction = myEnterprise.getTransactions().get(i);
            tempCustomer = tempTransaction.getPurchaser();
            y = tempTransaction.getPurchaseDate().getYear();
            if(tempCustomer.getCustomerID() == customerID && year == y)
            {
                check = 1;
                info = new JTextPane();
                info.setText(tempTransaction.toString());
                info.setFont(new Font("SansSerif", Font.PLAIN, 13));
                purchasesPanel.add(info);
            }
        }
        if(check == 0)
        {
            info = new JTextPane();
            info.setText("No purchases made");
            info.setFont(new Font("SansSerif", Font.PLAIN, 20));
            purchasesPanel.add(info);
        }
    }
    
    public void buildBackButton()
    {
        backButton = new JButton("Back to Main Page");
        backButton.addActionListener(new backButtonListener());
        backButton.setBackground(Color.WHITE);
        backButton.setFont(new Font("SansSerif", Font.PLAIN, 25));
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
