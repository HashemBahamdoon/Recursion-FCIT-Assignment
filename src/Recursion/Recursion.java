/*
name:Hashem Bahamdoon
email: hashimba2000@gmail.com, 
assignment name: recursion
date:friday oct 9, 2020
 */
package Recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) throws FileNotFoundException {

         File fileInput = new File("input.in.txt");
        Scanner readcommands = new Scanner(fileInput);

        PrintWriter pen = new PrintWriter("output.out.txt");
        int numberOfCommands = readcommands.nextInt();
        doCommand(numberOfCommands, readcommands, pen);
    }

    public static void doCommand(int numberOfCommands, Scanner readcommands,PrintWriter pen) {
        //base case
        if (numberOfCommands <= 0) {
        pen.flush();
        pen.close();
            return;
       
        }

        if (numberOfCommands == 9) {

            DescArrayCheck(readcommands,pen);

            //here start calling it selfe 
            doCommand(numberOfCommands - 1, readcommands,pen);

        } else if (numberOfCommands == 8) {

            DescArrayCheck(readcommands,pen);

            //here start calling it selfe 
            doCommand(numberOfCommands - 1, readcommands,pen);

        } else if (numberOfCommands == 7) {

            DescArrayCheck(readcommands,pen);

            //here start calling it selfe 
            doCommand(numberOfCommands - 1, readcommands,  pen);

        } else if (numberOfCommands == 6) {

            DescArrayCheck(readcommands,pen);

            //here start calling it selfe 
            doCommand(numberOfCommands - 1, readcommands,  pen);

        } else if (numberOfCommands == 5) {
            PrintHexNum(readcommands,pen);
            
             //here start calling it selfe 
            doCommand(numberOfCommands - 1, readcommands,  pen);

        } else if (numberOfCommands == 4) {
          
           PrintHexNum(readcommands,pen);
           
            //here start calling it selfe 
      doCommand(numberOfCommands - 1, readcommands,  pen);

        } else if (numberOfCommands == 3) {
            Noccurrences(readcommands,pen);

            //here start calling it selfe 
            doCommand(numberOfCommands - 1, readcommands,  pen);
        } else if (numberOfCommands == 2) {
            Noccurrences(readcommands,pen);

            //here start calling it selfe
            doCommand(numberOfCommands - 1, readcommands,  pen);

        } else if (numberOfCommands == 1) {
            Noccurrences(readcommands,pen);

            //here start calling it selfe
            doCommand(numberOfCommands - 1, readcommands,  pen);
        }

    }
       public static void  PrintHexNum(Scanner readcommands,PrintWriter pen){
       String DecToHex = readcommands.next();
            String numStr = readcommands.next();
            pen.println(DecToHex + " " + numStr + " (Decimal)");
            int DecNum = Integer.parseInt(numStr);

            char numHex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

            String result = DecToHex(DecNum, 0, numHex, "");

            pen.println("Result: " + result + "  (Hexadecimal)");
            pen.println("");
       
       }
    public static String DecToHex(int numDec, int reminder, char numHex[], String HexAsStr) {
        if (numDec == 0) {
            return HexAsStr;
        }

        reminder = numDec % 16;

        return DecToHex(numDec / 16, reminder, numHex, numHex[reminder] + HexAsStr);

    }

    public static void Noccurrences(Scanner readcommands,PrintWriter pen) {

        String Noccurrences = readcommands.next();
        String string = readcommands.next();
        String subString = readcommands.next();
        int at_Least_Num_Of_Occurrences = readcommands.nextInt();
        pen.println(Noccurrences + " " + string + "  " + subString + "  " + at_Least_Num_Of_Occurrences);

        if (numOfOccurrences(string, subString, at_Least_Num_Of_Occurrences, 0) == 1) {
            pen.println("Result: true (" + string + " contains more than " + at_Least_Num_Of_Occurrences + " occurrences of " +"\""+ subString +"\""+ ")");
        } else {
            pen.println("Result: false (" + string + " contains less than " + at_Least_Num_Of_Occurrences + " occurrences of " +"\""+ subString +"\""+ ")");
        }
        pen.println("");

    }

    public static void DescArrayCheck(Scanner readcommands,PrintWriter pen) {

        String DescArrayCheck = readcommands.next();
        String string = readcommands.next();
        pen.println(DescArrayCheck + " " + string);

        String numStr[] = string.split(";");
        int numInt[] = new int[numStr.length];
        // to convert from array of String to array of int without using loop
        parseIntRec(numStr.length, 0, numStr, numInt);
        if (descendingOrNot(numInt, 0) == 1) {
           pen.println("Result: 1 (Array elements are sorted in descending order)");
        } else {
            pen.println("Result: 0 (Array elements are not sorted in descending order)");
        }
        pen.println("");
    }

    public static int numOfOccurrences(String string, String subString, int at_Least_Num_Of_Occurrences, int num_Of_Occurrences) {
        //base case
        if (at_Least_Num_Of_Occurrences == num_Of_Occurrences) {

            return 1;

        }
        //here check if first 3 index same subString or not if it is true we increment num_Of_Occurrences
        if (string.substring(0, subString.length()).equalsIgnoreCase(subString)) {

            return numOfOccurrences(string.substring(1), subString, at_Least_Num_Of_Occurrences, num_Of_Occurrences + 1);
// if not we keep going to see next 3 index without increment num_Of_Occurrences
        } else if (string.length() > subString.length()) {
            return numOfOccurrences(string.substring(1), subString, at_Least_Num_Of_Occurrences, num_Of_Occurrences);
// here if not at_Least_Num_Of_Occurrences = num_Of_Occurrences and it arrived to the end
        } else {
            return 0;
        }

    }

    public static int descendingOrNot(int[] numsOfInt, int postion) {
        //base case
        if (postion == numsOfInt.length - 1) {
            return 1;
        }

        if (numsOfInt[postion] > numsOfInt[postion + 1]) {

            return descendingOrNot(numsOfInt, postion + 1);

        } else {
            return 0;

        }

    }

    public static void parseIntRec(int arrayLength, int postion, String arrayS[], int arrayInt[]) {
        //base case
        if (arrayLength - 1 == postion) {
            return;
        }
        arrayInt[postion] = Integer.parseInt(arrayS[postion]);

        parseIntRec(arrayLength, postion + 1, arrayS, arrayInt);
    }
}
