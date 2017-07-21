public class Transaction
{
    private Item purchasedItem;
    private Customer purchaser; 
    private Date purchaseDate;
    private int qunaityOfPurchase;
    private double transactionCost;
    /**
     * Constructor for transaction with no date specified
     * @param purchasedItemInfo
     * @param customerId
     * @param quanity
     * @param cost 
     */
    public Transaction(Item purchasedItemInfo, Customer customer, int quanity, double cost)
    {
        purchasedItem = purchasedItemInfo;
        purchaser = customer;
        purchaseDate = new Date();
        qunaityOfPurchase = quanity;
        transactionCost = cost;
    }
    /**
     * Constructor for transaction with string for date
     * @param purchasedItemInfo
     * @param customerId
     * @param dateOfPurchase
     * @param quanity
     * @param cost 
     */
    public Transaction(Item purchasedItemInfo, Customer customer,String dateOfPurchase, int quanity, double cost)
    {
        purchasedItem = purchasedItemInfo;
        purchaser = customer;
        purchaseDate = new Date(dateOfPurchase);
        qunaityOfPurchase = quanity;
        transactionCost = cost;
    }
    /**
     * Constructor for transaction with date object of date
     * @param purchasedItemInfo
     * @param customerId
     * @param dateOfPurchase
     * @param quanity
     * @param cost 
     */
    public Transaction(Item purchasedItemInfo, Customer customer,Date dateOfPurchase, int quanity, double cost)
    {
        purchasedItem = purchasedItemInfo;
        purchaser = customer;
        purchaseDate = dateOfPurchase;
        qunaityOfPurchase = quanity;
        transactionCost = cost;
    }
    
    public String toString()
    {
        return "item Id: "+purchasedItem.getItemId()+" | Customer id: "+purchaser.getCustomerID()+" | Purchase Date: "+purchaseDate+" | Qunaity: "+qunaityOfPurchase+" | Transaction cost: "+transactionCost;
    }
    
    public static void main(String[] args)
    {
      
    }
    
    public Item getPurchasedItem()
    {
        return purchasedItem;
    }
    
    public Date getPurchaseDate()
    {
        return purchaseDate;
    }
    
    public int getQunaityOfPurchase()
    {
        return qunaityOfPurchase;
    }
    
    public double getTransactionCost()
    {
        return transactionCost;
    }
    
    public Customer getPurchaser()
    {
        return purchaser;
    }
}