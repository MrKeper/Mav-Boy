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
public class itemPage extends JFrame
{
    private Enterprise myEnterprise;
    private final int WINDOW_WIDTH = 1280; 
    private final int WINDOW_HEIGHT = 720; 
    private JButton backButton;
    private JPanel itemPanel;
    private JScrollPane scrollPane;

    
    
    public itemPage(Enterprise e)
    {
        myEnterprise = e;
        setTitle("MavBoy Enterprise's Item List");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout b = new BorderLayout();
        setLayout(b);
        buildBackButton();
        buildItemPanel();
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
    
    public void buildItemPanel()
    {
        JTextPane itemInfo;
        Enterprise tempEnt = getEnterprise();
        Item tempItem = tempEnt.getItems().get(0);
        itemPanel = new JPanel();
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setLayout(new GridLayout(tempEnt.getItems().size(),1));
        itemInfo = new JTextPane();
        for(int i = 0; i < tempEnt.getItems().size();i++)
        { 
            itemInfo = new JTextPane();
            itemInfo.setText(tempEnt.getItems().get(i).toString());
            itemInfo.setFont(new Font("SansSerif", Font.PLAIN, 15));
            itemPanel.add(itemInfo);
            tempItem = tempEnt.getItems().get(i);
            
        }
        itemInfo.setEditable(false);
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
