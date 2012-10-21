/**
 * CSVRead.java: Reads a Comma Separated Value file and returns a a chained list
 * of chained lists with the vaules read.
 */
package test;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Dawid
 */
public class CSVReadGen {

/**
 * 
 * @param filename the filename of the CSV-file, eg. "Test.csv"
 * @param separator the separator, usually ","
 * @return returns a chained list containing of chained lists containing the content of the rows
 * @throws Exception 
 */
    static public LinkedList<LinkedList> readCSV(String filename, String separator) throws Exception {

        LinkedList<LinkedList> list = new LinkedList<>();
        BufferedReader CSVFile = new BufferedReader(new FileReader(filename));

        String dataRow = CSVFile.readLine();
        while (dataRow != null) {           //runs until it gets to an empty row
            LinkedList<String> strList = new LinkedList<>();
            String[] dataArray = dataRow.split(separator);      //the row is split on the separator and put into an array
            strList.addAll(Arrays.asList(dataArray));   //the array is loaded into a string list
            list.add(strList);                  //the list with the strings is added to the main linked list
            
            dataRow = CSVFile.readLine(); // Read next line of data.
        }
        // Close the file once all data has been read.
        CSVFile.close();

        return list;
    }
/**
 * use of the standard separator ","
 */
    static public LinkedList<LinkedList> readCSV(String filename) throws Exception {
        return (readCSV(filename, ","));        
    }
}
