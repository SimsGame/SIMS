package test;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Provides static methods to read and write CSV-Files (can also be used for
 * normal text files)
 *
 * @author Dawid Rusin
 */
public class CSVHandling {

    /**
     * reads a CSV-File
     *
     * @param filename name of the file to read from
     * @param separator string which separates the items from each other,
     * usually ","
     * @return chained list of chained lists with the content of the rows
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
     * reads a CSV-File uses the standard separator ","
     *
     * @param filename name of the file to read from
     * @return chained list with of chained lists containing the content of the
     * rows
     * @throws Exception
     */
    static public LinkedList<LinkedList> readCSV(String filename) throws Exception {
        return (readCSV(filename, ","));
    }

    /**
     * reads a CSV-File
     *
     * @param filename name of the file to read from
     * @return string with the content of the file, the lines are split by the
     * "\n"-character
     * @throws Exception
     */
    static public String readCSVString(String filename) throws Exception {

        String content = "";
        BufferedReader CSVFile = new BufferedReader(new FileReader(filename));
        String dataRow = CSVFile.readLine();
        if (dataRow != null) {
            content += dataRow;
            dataRow = CSVFile.readLine();
        }
        while (dataRow != null) {           //runs until it gets to an empty row
            content += "\n" + dataRow;      //writes the line into the string
            dataRow = CSVFile.readLine(); // Read next line of data.
        }
        // Close the file once all data has been read.
        CSVFile.close();

        return content;
    }

    /**
     * reads a CSV-File
     *
     * @param filename the filename of the CSV-file, eg. "Test.csv"
     * @return string-array with the content of the file, each element is a line
     * @throws Exception
     */
    static public String[] readCSVStringArr(String filename) throws Exception {

        return readCSVString(filename).split("\n");
    }

    /**
     * reads a CSV-File
     *
     * @param filename the filename of the CSV-file, eg. "Test.csv"
     * @param separator string which separates the items from each other,
     * usually ","
     * @return string-array with the content of the file, first index are the
     * rows, second index are the items
     * @throws Exception
     */
    static public String[][] readCSVStringArr2(String filename, String separator) throws Exception {
        String[] helper = readCSVStringArr(filename);
        String[][] content = new String[helper.length][];
        for (int i = 0; i < helper.length; i++) {
            content[i] = helper[i].split(separator);
        }
        return content;
    }

    /**
     * reads a CSV-File, uses the standard separator ","
     *
     * @param filename the filename of the CSV-file, eg. "Test.csv" usually ","
     * @return string-array with the content of the file, first index are the
     * rows, second index are the items
     * @throws Exception
     */
    static public String[][] readCSVStringArr2(String filename) throws Exception {
        return readCSVStringArr2(filename, ",");
    }

    /**
     * (re)writes a CSV-File
     *
     * @param list list of list with the content of the file
     * @param filename path + name of the file to write
     * @param separator will be written between the items to separate the from
     * each other
     * @throws Exception
     */
    static public void writeCSV(LinkedList<LinkedList> list, String filename, String separator) throws Exception {

//        BufferedWriter CSVFile = new BufferedWriter(new FileWriter(filename));
        String dataRow = "";
        LinkedList sublist = list.pop();
        if (!sublist.isEmpty()) {
            dataRow += sublist.pop();
        }
        while (!sublist.isEmpty()) {
            dataRow += separator + sublist.pop();
        }
        while (!list.isEmpty()) {
            dataRow += "\n";
            sublist = list.pop();
            if (!sublist.isEmpty()) {
                dataRow += sublist.pop();
            }
            while (!sublist.isEmpty()) {
                dataRow += separator + sublist.pop();
            }
        }
//        CSVFile.write(dataRow);
//        CSVFile.close();
        writeFile(dataRow, filename);
    }

    /**
     * (re)writes a CSV-File, uses "," as separator
     *
     * @param list list of list with the content of the file
     * @param filename path + name of the file to write
     * @throws Exception
     */
    static public void writeCSV(LinkedList<LinkedList> list, String filename) throws Exception {
        writeCSV(list, filename, ",");
    }

    /**
     * (re)writes a CSV-File
     *
     * @param str 2-dimensional string-array with the content of the file,
     * str[0][5] is the 6th element in the 1st row
     * @param filename path + name of the file to write
     * @param separator will be written between the items to separate the from
     * each other
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

    /**
     * (re)writes a CSV-File, uses "," as separator
     *
     * @param str 2-dimensional string-array with the content of the file,
     * str[0][5] is the 6th element in the 1st row
     * @param filename path + name of the file to write each other
     * @throws Exception
     */
    static public void writeCSV(String[][] str, String filename) throws Exception {
        writeCSV(str, filename, ",");
    }

    /**
     * (re)writes a (CSV-)File (same as writeFile())
     *
     * @param text 1-dimensional string-array with the content of the file,
     * text[1] is the 2nd line of the file
     * @param filename path + name of the file to write
     * @throws Exception
     */
    static public void writeCSV(String[] text, String filename) throws Exception {
        writeFile(text, filename);
    }

    /**
     * (re)writes a text file
     *
     * @param text 1-dimensional string-array with the content of the file,
     * text[1] is the 2nd line of the file
     * @param filename path + name of the file to write
     * @throws Exception
     */
    static public void writeFile(String[] text, String filename) throws Exception {
        String[][] str = new String[text.length][1];
        int i;
        for (i = 0; i < text.length; i++) {
            str[i][0] = text[i];
        }
        writeCSV(str, filename);
    }

    /**
     * (re)writes a text file
     *
     * @param text string with the content of the file
     * @param filename path + name of the file to write
     * @throws Exception
     */
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
