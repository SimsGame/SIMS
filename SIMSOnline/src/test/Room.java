/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Kira
 */
public class Room {
   
    private double airQuality;
    private double noise;
    
    public Room (){
        this.airQuality=100;
        initNoise();
    }
    
    private void initNoise(){
        this.noise=Math.round(Math.random()*30);
    }    
    
    private void updateNoise(double factor){
        this.noise = this.noise + 1*factor;
    }
    
    private void updateAirQuality(double factor){
        this.airQuality = this.airQuality + 1*factor;
    }
    
    public double getNoise() {
        return this.noise;
    }    
    
    public double getAirQuality() {
        return this.airQuality;
    }
}
