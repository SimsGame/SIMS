/*
 CSV-Files lesen und schreiben, Doku kommt noch... hab beide Funktionalitäten 
 in eine Klasse gepackt, um die Imports klein zu halten... bitte ab jetzt diese 
 Klasse verwenden ;-) ich werd sie noch mit ein paar Funktionlitäten 
 erweitern... bei Fehlern/unerwarteten Exceptions bitte bescheidgeben ;-)
 */
package test;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author rusinda
 */
public class CSVHandling {

    /**
     * reads a CSV-File
     *
     * @param filename the filename of the CSV-file, eg. "Test.csv"
     * @param separator the separator, usually ","
     * @return returns a chained list containing of chained lists containing the
     * content of the rows
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

    static public String readCSVString(String filename, String separator) throws Exception {
        LinkedList<LinkedList> list = readCSV(filename, separator);
        String content = "";
        while (!list.isEmpty()) {
            LinkedList<String> sublist = list.pop();
            if (!sublist.isEmpty()) {
                content += sublist.pop();
            }
            while (!sublist.isEmpty()) {
                content += separator + sublist.pop();
            }
            content += "\n";
        }
        return content;
    }
    
    static public String readCSVString(String filename) throws Exception {
        return readCSVString(filename, ",");
    }
    
    static public String[] readCSVStringArr(String filename, String separator) throws Exception {
        LinkedList<LinkedList> list = readCSV(filename, separator);
        String[] content = new String[list.size()];
        int i = 0;
        while (!list.isEmpty()) {
            content[i] = new String("");
            LinkedList<String> sublist = list.pop();
            if (!sublist.isEmpty()) {
                content[i] += sublist.pop();
            }
            while (!sublist.isEmpty()) {
                content[i] += separator + sublist.pop();
            }
            i++;
            
        }
        
        return content;
    }
    
    static public String[] readCSVStringArr(String filename) throws Exception {
        return readCSVStringArr(filename, ",");
    }

    /**
     * (re)writes a CSV-FIle
     *
     * @param list list with list containing the content of the file
     * @param filename filename of the file to write
     * @param separator separator between the content i a row
     * @throws Exception
     */
    static public void writeCSV(LinkedList<LinkedList> list, String filename, String separator) throws Exception {

//        BufferedWriter CSVFile = new BufferedWriter(new FileWriter(filename));
        String dataRow = "";
        while (!list.isEmpty()) {
            LinkedList sublist = list.pop();
            if (!sublist.isEmpty()) {
                dataRow += sublist.pop();
            }
            while (!sublist.isEmpty()) {
                dataRow += separator + sublist.pop();

            }
            dataRow += "\n";
        }
//        CSVFile.write(dataRow);
//        CSVFile.close();
        writeFile(dataRow, filename);
    }

    static public void writeCSV(LinkedList<LinkedList> list, String filename) throws Exception {
        writeCSV(list, filename, ",");
    }

    /**
     * takes a 2-dimensional string-array instead of a linked list
     *
     * @param str 2d string array with the content to write
     * @param filename filename of the file to write
     * @param separator separator between the content i a row
     * @throws Exception
     */
    static public void writeCSV(String[][] str, String filename, String separator) throws Exception {
        int i;
        LinkedList<LinkedList> list = new LinkedList();
        for (i = 0; i < str.length; i++) {
            LinkedList<String> sublist = new LinkedList<>();
            sublist.addAll(Arrays.asList(str[i]));
            list.add(sublist);
        }
        writeCSV(list, filename, separator);
    }

    static public void writeCSV(String[][] str, String filename) throws Exception {
        writeCSV(str, filename, ",");
    }

    static public void writeCSV(String[] text, String filename) throws Exception {
        writeFile(text, filename);
    }

    static public void writeFile(String[] text, String filename) throws Exception {
        String[][] str = new String[text.length][1];
        int i;
        for (i = 0; i < text.length; i++) {
            str[i][0] = text[i];
        }
        writeCSV(str, filename);
    }

    static public void writeFile(String text, String filename) throws Exception {
        String[] str = filename.split("/");
        String dirs = new String();
        for (int i = 0; i < str.length - 1; i++) {
            dirs += str[i] + "/";
        }
        File file = new File(dirs);
        file.mkdirs();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename));
        fileWriter.write(text);
        fileWriter.close();
    }
}
