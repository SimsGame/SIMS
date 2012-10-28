/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Jörg Woditschka
 * Objects of this class contain an array of Student Objects.
 * Use the getArray() method of your created StudentArray to get the
 * array of Students as return. (e.g. for getting the ID of the 2nd Student in
 * the Array:
 * int id = myArray.getArray()[2].getId();
 */
public class StudentArray {

    private Student[] studentArray;

    public StudentArray() {
        initArray();
    }

    private void initArray() {
        studentArray = new Student[30];
        for (int i = 0; i < 30; i++) {
            studentArray[i] = new Student(i);
        }
    } 
    /* Added by Kira
     * Regularly called with testvalue:
     * double factor1 = 101-classroom.airQuality/200*(-3.3)
     * double factor2 = classroom.noise/200*3.3
     */
    
   
    
    public Student[] getArray(){
        return studentArray;
    }
}