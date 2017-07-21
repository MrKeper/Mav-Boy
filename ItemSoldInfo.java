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
public class ItemSoldInfo extends JFrame
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JButton backButton;
    private JPanel itemPanel;
    private JScrollPane scrollPane;
    private String itemId;
    
    public ItemSoldInfo(Enterprise e, String id)
    {
        myEnterprise = e;
        itemId = id;
        setTitle("Item Transaction Info");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildInfoPanel();
        scrollPane = new JScrollPane(itemPanel);
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
    
    public void buildInfoPanel()
    {
         Enterprise tempEnt = myEnterprise;
        JTextPane itemInfo;
        Item tempItem;
        int count = 0;
        double totalRev = 0;
        itemPanel = new JPanel();
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setLayout(new GridLayout(tempEnt.getTransactions().size()+1,1));
        itemInfo = new JTextPane();
        Transaction tempTransaction;
        for(int i = 0; i < tempEnt.getTransactions().size();i++)
        { 
            tempTransaction = tempEnt.getTransactions().get(i);
            if(tempTransaction.getPurchasedItem().getItemId().equals(itemId))
            {
                count++;
                itemInfo = new JTextPane();
                itemInfo.setText(tempTransaction.toString());
                itemInfo.setFont(new Font("SansSerif", Font.PLAIN, 15));
                itemPanel.add(itemInfo);
                totalRev += tempTransaction.getTransactionCost();
            }itemInfo.setEditable(false);
        }
        if(count == 0)
        {
            itemInfo = new JTextPane();
            itemInfo.setText("There are no purchases for this item");
            itemInfo.setFont(new Font("SansSerif", Font.PLAIN, 35));
            itemPanel.add(itemInfo);
            itemInfo.setEditable(false);
            return;
        }
        itemInfo = new JTextPane();
        itemInfo.setText("Total Revenue from Item: "+totalRev);
        itemInfo.setFont(new Font("SansSerif", Font.PLAIN, 15));
        itemPanel.add(itemInfo);
        
    }
    
    private class backButtonListener implements ActionListener
    {
         @Override
         public void actionPerformed(ActionEvent emp)
         {
             dispose();
         }

    }
    
    /*JPanel itemSales;
            Enterprise tempEnt = myEnterprise;
            Item tempItem,printItem=null;
            Transaction tempTransaction;
            for(int i = 0; i < tempEnt.getItems().size();i++)
            {
                tempItem = tempEnt.getItems().get(i);
                if(tempItem.getItemName().equals(itemID))
                {
                    printItem = tempItem;
                    break;
                }
            }
            double totalItemRevenue;
            if(printItem != null)
            {
                itemSales = new JPanel();
                JTextPane salesInfo;
                for(int i = 0; i < tempEnt.getTransactions().size();i++)
                {
                    tempTransaction = tempEnt.getTransactions().get(i);
                    if(tempTransaction.getPurchasedItem().getItemName().equals(itemID))
                    {
                            salesInfo = new JTextPane();
                            salesInfo.setText(tempTransaction.toString());
                            salesInfo.setFont(new Font("SansSerif", Font.PLAIN, 15));
                            itemSales.add(itemInfo);
                    }
                }
                scrollPane = new JScrollPane(itemSales);
                add(scrollPane,BorderLayout.CENTER);
            }
            else
            {
                
            }
            */
}
