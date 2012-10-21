/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Stazzer
 */
public class Game {
    public int ucoins = 5;
    public int credits = 60;
    public int points = 700; 
    
    public Item duplo = new Item();
    public Item redBull = new Item();
    public Item cheatSheet = new Item();
    public Item omniSenseAudio = new Item();
    
    public void setItems(String name, String image, int price, String currency, int amount, int availibility){
        if(name.equals("Duplo")){
            duplo.name = name;
            duplo.image = image;
            duplo.price = price;
            duplo.currency = currency;
            duplo.amount = amount;
            duplo.availibility = availibility;
            System.out.print(duplo.name);
        }
        if(name.equals("Red Bull")){
            redBull.name = name;
            redBull.image = image;
            redBull.price = price;
            redBull.currency = currency;
            redBull.amount = amount;
            redBull.availibility = availibility;
            System.out.print(redBull.name);
        }
        if(name.equals("Spickzettel")){
            cheatSheet.name = name;
            cheatSheet.image = image;
            cheatSheet.price = price;
            cheatSheet.currency = currency;
            cheatSheet.amount = amount;
            cheatSheet.availibility = availibility;
            System.out.print(cheatSheet.name);
        }
        if(name.equals("OMNI Sense Audiobuch")){
            omniSenseAudio.name = name;
            omniSenseAudio.image = image;
            omniSenseAudio.price = price;
            omniSenseAudio.currency = currency;
            omniSenseAudio.amount = amount;
            omniSenseAudio.availibility = availibility;
            System.out.print(omniSenseAudio.name);
        }
    }
}
