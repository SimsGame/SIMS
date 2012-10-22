/*
 * In this class all attributes of an item are defined
 */
package test;

import javax.swing.JLabel;

/**
 *
 * @author Jannik
 */
public class Item {
    
    Game game = new Game();
    
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
    
    //public Item item;
    public Item(){
        
    }
    
    public Item(String name, String image, int price, String currency, int amount, int availibility){
            this.name = name;
            this.image = image;
            this.price = price;
            this.currency = currency;
            this.amount = amount;
            this.availibility = availibility;
            //System.out.print(duplo.name);
            game.putItem(this);
    }
    
    public void createItemContainer(JLabel field, JLabel name){
        
    }
}
