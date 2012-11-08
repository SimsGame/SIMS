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
@Deprecated public class StudentArray {

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
   
    public Student[] getArray(){
        return studentArray;
    }
}