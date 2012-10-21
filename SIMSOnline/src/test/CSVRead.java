/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.*;
import java.util.Arrays;

/**
 *
 * @author Stazzer
 */
public class CSVRead {
    // CSVRead.java
//Reads a Comma Separated Value file and prints its contents.

 public static void main(String[] arg) throws Exception {
  //is = this.getClass().getResourceAsStream("config.txt");   
  BufferedReader CSVFile = 
        new BufferedReader(new FileReader("Test.csv"));

  String dataRow = CSVFile.readLine(); // Read first line.
  // The while checks to see if the data is null. If 
  // it is, we've hit the end of the file. If not, 
  // process the data.

  while (dataRow != null){
   String[] dataArray = dataRow.split(",");
   for (String item:dataArray) { 
      System.out.println(item);
   }
   //System.out.println(); // Print the data line.
   dataRow = CSVFile.readLine(); // Read next line of data.
  }
  // Close the file once all data has been read.
  CSVFile.close();

  // End the printout with a blank line.
  System.out.println();

 } //main()
}
