public class Item
{
    private final String itemID;
    private final String itemName;
    private final String itemDepartment;
    private double itemPrice;
    private final String itemSize;
    private final String itemType;
    private int itemQuanity;
    /**
     * Constructor for Item
     * @param id
     * @param name
     * @param department
     * @param price
     * @param size
     * @param type
     * @param quanity 
     */
    public Item(String id, String name, String department, double price, String size, String type, int quanity)
    {
        itemID = id;
        itemName = name;
        itemDepartment = department; //"ticketing" "merchandise"
        itemPrice = price;
        itemSize = size;
        itemType = type;
        itemQuanity = quanity;
    }
    /**
     * toString method for Item
     * @return 
     */
    
    public String toString()
    {
        if("ticketing".equals(itemDepartment))
            return "Item ID: "+itemID+" | Item Name: "+itemName+" | Item Price: "+itemPrice+" | Item Type: "+itemType+" | Item Quanity: "+itemQuanity;
        if("merchandise".equals(itemDepartment))
            return "Item ID: "+itemID+" | Item Name: "+itemName+" | Item Price: "+itemPrice+" | Item Size: "+itemSize+" | Item Quanity: "+itemQuanity;
        return "Error invalid item Department";
    }
    
    public static void main(String[] args)
    {
        
    }
    
    public String getItemId()
    {
        return itemID;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public String getItemDepartment()
    {
        return itemDepartment;
    }
    
    public double getItemPrice()
    {
        return itemPrice;
    }
    
    public String getItemSize()
    {
        return itemSize;
    }
    
    public String getItemType()
    {
        return itemType;
    }
    
    public int getItemQuanity()
    {
        return itemQuanity;
    }
    
    public void setItemPrice(int newItemPrice)
    {
        itemPrice = newItemPrice;
    }
    
    public void setItemQuanity(int newItemQuanity)
    {
        itemQuanity = newItemQuanity;
    }
    
   
    
}