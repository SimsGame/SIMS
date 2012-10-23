/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author rusinda
 */
@Deprecated public class CSVWriteGen {
    
    static public void writeCSV (LinkedList<LinkedList> list, String filename) throws Exception{
        writeCSV(list, filename, ",");
    }
    
    static public void writeCSV (LinkedList<LinkedList> list, String filename, String separator) throws Exception{
        
        BufferedWriter CSVFile = new BufferedWriter(new FileWriter(filename));
        String dataRow = "";
        while(!list.isEmpty()){
            LinkedList sublist = list.pollFirst();
            if(!sublist.isEmpty()){
                dataRow+=sublist.pollFirst();
            }
            while(!sublist.isEmpty()){
                dataRow+= separator + list.pollFirst();
            }
        }
        CSVFile.write(dataRow);
        CSVFile.close();
    }   
}
