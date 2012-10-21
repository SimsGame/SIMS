/*
 * In this class all attributes of an item are defined
 */
package test;

/**
 *
 * @author Jannik
 */
public class Item {
    
    /**
     * Public attributes to have an easier access from other classes.
     * @param name           Item name.
     * @param image          Item image.
     * @param price          Price for item in shop.
     * @param amount         Item in inventory.
     * @param availibility   Which semester is needed to get this item.
     * @param currency       Either UCoins or Credits. 
     */
    
    public String name;
    public String image;
    public int price;
    public String currency;
    public int amount;
    public int availibility;
    
}
