/*
 * CSVRead.java: Reads a Comma Separated Value file and prints its contents.
 */
package test;

import java.io.*;
import java.util.Arrays;

/**
 *
 * @author Jannik
 */
public class CSVRead {

    public String[] data = new String[24];
    int column = 4;

 public void readCSV() throws Exception{
  BufferedReader CSVFile = 
        new BufferedReader(new FileReader("Test.csv"));

  String dataRow = CSVFile.readLine(); // Read first line.
  // The while checks to see if the data is null. If 
  // it is, we've hit the end of the file. If not, 
  // process the data.
    int i = 0;
  while (dataRow != null){
   String[] dataArray = dataRow.split(",");
   for (String item:dataArray) { 
      data[i] = item;
      i++;
   }

   dataRow = CSVFile.readLine(); // Read next line of data.
  }
  // Close the file once all data has been read.
  CSVFile.close();
  
  // Filles the items with data
  for(int j=0; j<4; j++){
    Sims_1._maingame.putItem(data[j], Integer.parseInt(data[j+column]),Integer.parseInt(data[j+2*column]));
  }
 } 
}
