/*
 * In this class all attributes of an item are defined
 */
package test;

import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;

/**
 *
 * @author Jannik
 */
public class Item {
    
    public static final String _redBullName = "Red Bull";
    public static final int _redBullPrice = 30;
    public static final String _redBullCurrency = Sims_1._creditsName;
    public static final int _redBullMotivation = 0;
    public static final int _redBullTiredness = -30;
    public static final int _redBullKnowledge = 0;
    public static final String _duploName = "Duplo";
    public static final int _duploPrice = 30;
    public static final String _duploCurrency = Sims_1._creditsName;
    public static final int _duploMotivation = 30;
    public static final int _duploTiredness = 0;
    public static final int _duploKnowledge = 0;
    public static final String _omniSenseName = "OMNI Sense Audiobuch";
    public static final int _omniSensePrice = 100;
    public static final String _omniSenseCurrency = Sims_1._UCoinsName;
    public static final int _omniSenseMotivation = 0;
    public static final int _omniSenseTiredness = 0;
    public static final int _omniSenseKnowledge = 20;
    public static final String _spickerName = "Spickzettel";
    public static final int _spickerPrice = 100;
    public static final String _spickerCurrency = Sims_1._UCoinsName;
    public static final int _spickerMotivation = 0;
    public static final int _spickerTiredness = 0;
    public static final int _spickerKnowledge = 0;
    /**
     * Public attributes to have an easier access from other classes.
     *
     * @param name Item name.
     * @param price Price for item in shop.
     * @param amount Item in inventory.
     * @param availibility Which semester is needed to get this item.
     * @param currency Either UCoins or Credits.
     */
    public String name;
    public int price;
    public String currency;
    public int amount;
    public int available;
    public int motivation;
    public int tiredness;
    public int knowledge;

    //public Item item;
    public Item() {
    }

    /**
     * Creates a new Item and stores it in the Game.java file.
     *
     * @param name
     * @param price
     * @param currency
     * @param amount
     * @param availibility
     */
    public Item(String name) {
        this(name, 0, 5);
    }

    public Item(String name, int amount, int available) {
        switch (name) {
            case _redBullName:
                this.name = _redBullName;
                this.price = _redBullPrice;
                this.currency = _redBullCurrency;
                this.amount = amount;
                this.available = available;
                this.motivation = _redBullMotivation;
                this.tiredness = _redBullTiredness;
                this.knowledge = _redBullKnowledge;
                break;
            case _duploName:
                this.name = _duploName;
                this.price = _duploPrice;
                this.currency = _duploCurrency;
                this.amount = amount;
                this.available = available;
                this.motivation = _duploMotivation;
                this.tiredness = _duploTiredness;
                this.knowledge = _duploKnowledge;
                break;
            case _spickerName:
                this.name = _spickerName;
                this.price = _spickerPrice;
                this.currency = _spickerCurrency;
                this.amount = amount;
                this.available = available;
                this.motivation = _spickerMotivation;
                this.tiredness = _spickerTiredness;
                this.knowledge = _spickerKnowledge;
                //Sims_1._maingame.putItem(this);
                break;
            case _omniSenseName:
                this.name = _omniSenseName;
                this.price = _omniSensePrice;
                this.currency = _omniSenseCurrency;
                this.amount = amount;
                this.available = available;
                this.motivation = _omniSenseMotivation;
                this.tiredness = _omniSenseTiredness;
                this.knowledge = _omniSenseKnowledge;
                //Sims_1._maingame.putItem(this);
                break;
        }
    }
    
    /**
     * Creates each item container for the inventory.
     * The variabels define the coordinates and the width and height of the container.
     * Each item container includes a box for the image and two labels for the name and current amount.
     * 
     * @param field   The container holding the name and the amount.
     * @param name    Container in which the items name will be storred.
     * @param amaount Container which will hold the current amount of the item.
     * @param item    The item which will be displayed in the container.
     */
    
    public void createItemInventory(JLabel field, JLabel name, JLabel amount, Item item){
        int boxFactor = 100; 
        int itemBoxX = 30;
        int itemBoxY = 50;
        int itemBoxWidth = 80;
        int itemBoxHeight = 80;
        int labelFactor = 100;
        int itemLabelX = 30;
        int itemLabelY = 80;
        int itemLabelWidth = 80;
        int itemLabelHeight = 20;
        int itemAmountX = 30;
        int itemAmountY = 100;
        int itemAmountWidth = 80;
        int itemAmountHeight = 20;
        
        switch(item.name){
            case "Red Bull":{
                field.setIcon(new javax.swing.ImageIcon(getClass().getResource("/items/RedBullPainting80x80.png")));
                field.getParent().setComponentZOrder(field,field.getParent().getComponentCount()-1);
                name.getParent().setComponentZOrder(name,name.getParent().getComponentCount()-10);
                break;
            }
            case "Duplo":{
                field.setIcon(new javax.swing.ImageIcon(getClass().getResource("/items/FerreroDuploPainting80x80.png")));
                field.getParent().setComponentZOrder(field,field.getParent().getComponentCount()-2);
                name.getParent().setComponentZOrder(name,name.getParent().getComponentCount()-11);
                break;
            }
            case "OMNI Sense Audiobuch":{
                field.setIcon(new javax.swing.ImageIcon(getClass().getResource("/items/OMNISenseAudioPainting80x80.png")));
                field.getParent().setComponentZOrder(field,field.getParent().getComponentCount()-3);
                name.getParent().setComponentZOrder(name,name.getParent().getComponentCount()-12);
                break;
            }
            case "Spickzettel":{
                field.setIcon(new javax.swing.ImageIcon(getClass().getResource("/items/SpickzettelPainting80x80.png")));
                field.getParent().setComponentZOrder(field,field.getParent().getComponentCount()-4);
                name.getParent().setComponentZOrder(name,name.getParent().getComponentCount()-13);
                break;
            } 
        }
        
        //name.setText(item.name);
        name.setText("");
        name.setHorizontalAlignment(name.CENTER);
        name.setBackground(Color.black);
        name.setForeground(Color.white);
        //name.setOpaque(true);
        amount.setText(String.valueOf(item.amount)+" x");
        amount.setHorizontalAlignment(name.CENTER);
        amount.setBackground(Color.black);
        amount.setForeground(Color.white);
        amount.setOpaque(true);
        
        //The following part displays the container on the right position 
        
        if(item.name.equals("Red Bull")){
            field.setBounds(itemBoxX, itemBoxY, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY, itemAmountWidth, itemAmountHeight);
        }
        if(item.name.equals("Duplo") && Sims_1._maingame.redBull.amount != 0){
            field.setBounds(itemBoxX, itemBoxY+boxFactor, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY+labelFactor, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY+labelFactor, itemAmountWidth, itemAmountHeight);
        }
        else{
            field.setBounds(itemBoxX, itemBoxY, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY, itemAmountWidth, itemAmountHeight);
        }
        if(item.name.equals("OMNI Sense Audiobuch") && Sims_1._maingame.redBull.amount != 0 && Sims_1._maingame.duplo.amount != 0){
            field.setBounds(itemBoxX, itemBoxY+2*boxFactor, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY+2*labelFactor, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY+2*labelFactor, itemAmountWidth, itemAmountHeight);
        }
        else if(item.name.equals("OMNI Sense Audiobuch") && Sims_1._maingame.duplo.amount == 0 && Sims_1._maingame.redBull.amount != 0 || item.name.equals("OMNI Sense Audiobuch") && Sims_1._maingame.duplo.amount != 0 && Sims_1._maingame.redBull.amount == 0){
            field.setBounds(itemBoxX, itemBoxY+boxFactor, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY+labelFactor, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY+labelFactor, itemAmountWidth, itemAmountHeight);
        }
        else if(item.name.equals("OMNI Sense Audiobuch") && Sims_1._maingame.duplo.amount == 0 && Sims_1._maingame.redBull.amount == 0){
            field.setBounds(itemBoxX, itemBoxY, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY, itemAmountWidth, itemAmountHeight);
        }
        
        if(item.name.equals("Spickzettel") && Sims_1._maingame.redBull.amount != 0 && Sims_1._maingame.duplo.amount != 0 && Sims_1._maingame.omniSenseAudio.amount != 0){
            field.setBounds(itemBoxX, itemBoxY+3*boxFactor, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY+3*labelFactor, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY+3*labelFactor, itemAmountWidth, itemAmountHeight);
        }
        else if(item.name.equals("Spickzettel") && Sims_1._maingame.duplo.amount != 0 && Sims_1._maingame.redBull.amount != 0 && Sims_1._maingame.omniSenseAudio.amount == 0  || item.name.equals("Spickzettel") && Sims_1._maingame.duplo.amount != 0 && Sims_1._maingame.redBull.amount == 0 && Sims_1._maingame.omniSenseAudio.amount != 0 || item.name.equals("Spickzettel") && Sims_1._maingame.duplo.amount == 0 && Sims_1._maingame.redBull.amount != 0 && Sims_1._maingame.omniSenseAudio.amount != 0){
            field.setBounds(itemBoxX, itemBoxY+2*boxFactor, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY+2*labelFactor, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY+2*labelFactor, itemAmountWidth, itemAmountHeight);
        }
        else if(item.name.equals("OMNI Sense Audiobuch") && Sims_1._maingame.duplo.amount == 0 && Sims_1._maingame.omniSenseAudio.amount == 0 || item.name.equals("OMNI Sense Audiobuch") && Sims_1._maingame.duplo.amount == 0 && Sims_1._maingame.redBull.amount == 0 || item.name.equals("OMNI Sense Audiobuch") && Sims_1._maingame.redBull.amount == 0 && Sims_1._maingame.omniSenseAudio.amount == 0){
            field.setBounds(itemBoxX, itemBoxY+boxFactor, itemBoxWidth, itemBoxHeight);
            name.setBounds(itemLabelX, itemLabelY+labelFactor, itemLabelWidth, itemLabelHeight);
            amount.setBounds(itemAmountX, itemAmountY+labelFactor, itemAmountWidth, itemAmountHeight);
        }
         else if(item.name.equals("OMNI Sense Audiobuch") && Sims_1._maingame.duplo.amount == 0 && Sims_1._maingame.omniSenseAudio.amount == 0 && Sims_1._maingame.redBull.amount == 0){
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
     * @param name    The label which will be filled with the items name later.
     * @param price   The label which will be filled with the items price later.
     * @param locked  Looks if the item is available.
     * @param item    The item that shall be displayed.
     */
    
    public static void createItemShop(JLabel name, JLabel price, JLabel locked, Item item){
        
        name.setHorizontalAlignment(JLabel.CENTER);
        price.setHorizontalAlignment(JLabel.CENTER);
        
        if(item.available > Sims_1._maingame.semester){
            name.setText("Verfügbar ab Semester "+item.available);
            price.setVisible(false);
        }else{
            locked.setVisible(false);
            name.setText(item.name);
            price.setText(item.price+" "+item.currency);
        }
    }
    
    /**
     * Updates the Inventory if someone bought something in the shop.
     * @param item   The container that will be updated.
     * @param it     The item which was bought.
     * @param price  The Credits or UCoins label. 
     * @param value  The new value of coins after the buy.
     */
    
    public static void updateInventroy(JLabel item, Item it, JLabel price, int value){
        item.setText(""+it.amount+" x");
        price.setText(""+value);
    }
    
    /*
     * Added by Julia
     * @param item label in the planning phase that will be updated
     * @param it item that will be updated
     */
     public static void updateInventoryPlanningPhase(JLabel item, Item it){
       if (it.name.equals("OMNI Sense Audiobuch")) {
           item.setText("OmniSense Bücher: " +it.amount +"x" );
       }
       else{

        item.setText(it.name +": " +it.amount+"x");
       }
     }
    
    /**
     * Manages everything if a player clicks an item in the shop.
     * @param item   The item that the player clicked.
     * @param locked Looks if the player is allowed to buy this item.
     * @return 
     */
    
    public static int managePurchase(Item item, JLabel locked){
        if(locked.isVisible() == true){
            return 1;
        }
        
        if(item.currency.equals("Credits") && Sims_1._maingame.credits<item.price || item.currency.equals("UCoins") && Sims_1._mainuser.getUcoins()<item.price){
            return 1; 
        }
        else{
            item.amount += 1;
            if(item.currency.equals("Credits"))
                Sims_1._maingame.credits = Sims_1._maingame.credits-item.price;
            else
                Sims_1._mainuser.setUcoins(Sims_1._mainuser.getUcoins()-item.price);
            return 0;
        }
    }
}
