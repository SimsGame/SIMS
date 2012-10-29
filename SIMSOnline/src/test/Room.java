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
   
    /**
     *  @param airQuality       The quality of the air within the classroom
     *  @param noise            How loud it is within the classroom
     * 
     */
    private double airQuality;
    private double noise;
    
    // constructor
    // noise is initialised by a method, airQuality 
    public Room (){
        this.airQuality=100;
        initNoise();
    }
    
    // initialisation of the noise. A starting value between 0 and 30 will be chosen.
    private void initNoise(){
        this.noise=Math.round(Math.random()*30);
    }    
    
    /* updating of the air quality, based on the factor. Factor is determined by the statuses window open/closed.
     * tentative default value is 0.5
     * called every second
     */  
    public void updateNoise(double factor){
        this.noise = this.noise + 1*factor;
    }
    
    /* updating of the air quality, based on the factor. Factor is determined by the statuses window open/closed.
     * tentative default value is 0.5
     * calles every second
     */
    public void updateAirQuality(double factor){
        this.airQuality = this.airQuality + 1*factor;
    }
    
    public double getNoise() {
        return this.noise;
    }    
    
    public double getAirQuality() {
        return this.airQuality;
    }
}
