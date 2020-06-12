package com.company.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTest {
    public static void main(String [] atgs) throws FileNotFoundException {
//        Scanner sc = new Scanner(new File("/Users/ddada/Documents/ta/profectus/profectus-nibss-settlementrecon-service/src/test/resources/narration.txt"));
//        int max= 0;
//        String maxText= "";
//        while(sc.hasNextLine()){
//            String text = sc.nextLine();
//            //System.out.println(text);
//            if(max< text.length() ){
//                max= text.length();
//                maxText = text;
//            }
//        }
//        System.out.println(max + " "+ maxText);
        getCommaSeperatedExceptions();
    }

    public static void getCommaSeperatedExceptions() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/Users/ddada/Documents/danpersonal/livejavaproject/hackerrank/src/com/company/Files/exceptionsfromlive.csv"));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sc.hasNextLine()){
            count++;
            sb.append("'"+sc.nextLine()+"'").append(",");
            //System.out.println(text)
        }

        System.out.println(sb.toString());
        System.out.println(count);
    }
}
