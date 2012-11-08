/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Kira
 */
public class Attributes {
    
    
    
    private Student[] changeArray;
    
    public double changeTiredness(int i, double factor)
    {
       double tiredness = changeArray[i].getTiredness();
       tiredness = tiredness+1*factor;
       return tiredness;
    }
     
    public double changeMotivation(int i, double factor)
    {
       double motivation = changeArray[i].getMotivation();
       motivation = motivation+1*factor;
       return motivation;              
    }
    
    public double changeAirQuality(int i, double factor)
    {
       double airQuality = changeArray[i].getTiredness();
       airQuality = airQuality+1*factor;
       return airQuality;              
    }

    public double changeNoise(int i, double factor)
    {
       double noise = changeArray[i].getTiredness();
       noise = noise+1*factor;
       return noise;              
    }
        
    /* Added by Kira
     * Regularly called with testvalue:
     * double factor1 = 101-classroom.airQuality/200*(-3.3)
     * double factor2 = classroom.noise/200*3.3
     * airQuality changes regularly with -0.5
     * noise with 0.5 
     */   
}
