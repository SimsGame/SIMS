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
    
    /**
     * Creates each item container for the inventory.
     * The variabels define the coordinates and the width and height of the container.
     * Each item container includes a box for the image and two labels for the name and current amount.
     */
    
    public void createItemInventory(JLabel field, JLabel name, JLabel amount, Item item){
        int boxFactor = 120; 
        int itemBoxX = 25;
        int itemBoxY = 50;
        int itemBoxWidth = 100;
        int itemBoxHeight = 100;
        int labelFactor = 120;
        int itemLabelX = 35;
        int itemLabelY = 100;
        int itemLabelWidth = 80;
        int itemLabelHeight = 20;
        int itemAmountX = 33;
        int itemAmountY = 120;
        int itemAmountWidth = 80;
        int itemAmountHeight = 20;
        
        name.setText(item.name);
        name.setHorizontalAlignment(name.CENTER);
        amount.setText(String.valueOf(item.amount)+" x");
        amount.setHorizontalAlignment(name.CENTER);
        
        
        if(item.name.equals("Red Bull")){
            field.setBounds(itemBoxX, itemBoxY, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY, itemAmountWidth, itemAmountHeight);
        }
        if(item.name.equals("Duplo") && game.redBull.amount != 0){
            field.setBounds(itemBoxX, itemBoxY+boxFactor, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY+labelFactor, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY+labelFactor, itemAmountWidth, itemAmountHeight);
        }
        else{
            field.setBounds(itemBoxX, itemBoxY, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY, itemAmountWidth, itemAmountHeight);
        }
        if(item.name.equals("OMNI Sense Audiobuch") && game.redBull.amount != 0 && game.duplo.amount != 0){
            field.setBounds(itemBoxX, itemBoxY+2*boxFactor, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY+2*labelFactor, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY+2*labelFactor, itemAmountWidth, itemAmountHeight);
        }
        else if(item.name.equals("OMNI Sense Audiobuch") && game.duplo.amount == 0 && game.redBull.amount != 0 || item.name.equals("OMNI Sense Audiobuch") && game.duplo.amount != 0 && game.redBull.amount == 0){
            field.setBounds(itemBoxX, itemBoxY+boxFactor, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY+labelFactor, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY+labelFactor, itemAmountWidth, itemAmountHeight);
        }
        else if(item.name.equals("OMNI Sense Audiobuch") && game.duplo.amount == 0 && game.redBull.amount == 0){
            field.setBounds(itemBoxX, itemBoxY, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY, itemAmountWidth, itemAmountHeight);
        }
        
        if(item.amount == 0){
            field.setVisible(false);
            name.setVisible(false);
            amount.setVisible(false);
        }
    }
    
    /**
     * Creates the item container for the shop.
     * @param field
     * @param name
     * @param amount 
     */
    
    public void createItemShop(JLabel name, JLabel price, JLabel locked, Item item){
        
        name.setHorizontalAlignment(JLabel.CENTER);
        price.setHorizontalAlignment(JLabel.CENTER);
        
        if(item.availibility > game.semester){
            name.setText("Verfügbar ab Semester "+item.availibility);
            price.setVisible(false);
        }else{
            locked.setVisible(false);
            name.setText(item.name);
            price.setText(item.price+" "+item.currency);
        }
    }
    
    public void updateInventroy(JLabel item, Item it, JLabel price, int value){
        item.setText(""+it.amount+" x");
        price.setText(""+value);
    }
    
    public int managePurchase(Item item, JLabel locked){
        if(locked.isVisible() == true){
            return 1;
        }
        
        if(item.currency.equals("Credits") && game.credits<item.price || item.currency.equals("UCoins") && game.ucoins<item.price){
            return 1;
        }
        else{
            item.amount += 1;
            if(item.currency.equals("Credits"))
                game.credits = game.credits-item.price;
            else
                game.ucoins = game.ucoins-item.price;
            return 0;
        }
    }
}
