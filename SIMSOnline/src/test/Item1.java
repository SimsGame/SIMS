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
public class Item1 {

    public static final String _redBullName = "RedBull";
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
    public static final String _omniSenseName = "Omni SENSE Audiobuch";
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
    public boolean available;
    public int motivation;
    public int tiredness;
    public int knowledge;

    //public Item item;
    public Item1() {
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
    public Item1(String name) {
        this(name, 0, false);
    }

    public Item1(String name, int amount, boolean available) {
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
                break;
        }
    }
}