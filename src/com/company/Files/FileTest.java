package com.company.Files;

import com.sun.tools.javac.util.ArrayUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
//        getCommaSeperatedExceptions();

//        System.out.println("nip_inward_recon".toUpperCase());

        createFile();
    }

    public static void createDirectoryAutomatically(){
        File file = new File("C:\\user\\Desktop\\dir1\\dir2\\filename.txt");
        file.getParentFile().mkdirs();
        try {
            FileWriter writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(){
//        File file = new File("C:\\user\\Desktop\\dir1\\dir2\\filename.txt");
//        file.getParentFile().mkdirs();
////        FileWriter writer = new FileWriter(file);

        String from = "/Users/ddada/Documents/danpersonal/livejavaproject/hackerrank/src/com/company/Files/kreate/create/Narration.txt";
        File dir = new File(from);
        dir.getParentFile().mkdirs();

//        if(!dir.exists())
//            dir.mkdirs();
        try {
            Path path = Paths.get(from ); //creates Path instance

            Path createdPath = Files.createFile(path);
            System.out.println(Files.exists(createdPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void moveFile(){
        String from = "/Users/ddada/Documents/danpersonal/livejavaproject/hackerrank/src/com/company/" +
                "Files/Narration.txt";
        String toPath = "/Users/ddada/Documents/danpersonal/livejavaproject/hackerrank/src/com/company/" +
                "Files/copied";
        String newNameOfFile = "THE NAME I WANT.txt";
        File file=new File(from);
        File newFile = new File(toPath + File.separator + newNameOfFile);
        System.out.println("before moving file path name==>"+ file.getName());
        System.out.println("About moving");

        if(newFile.exists()){
            System.out.println("it exist so delete");
            boolean status =newFile.delete();
            System.out.println(status);

            System.out.println("deleted successfully");
            newFile=new File(toPath+File.separator+newNameOfFile);
            boolean stat = file.renameTo(newFile);
            System.out.println(stat);

        }else {
            newFile=new File(toPath+File.separator+newNameOfFile);
            file.renameTo(newFile);
        }
        System.out.println(newFile.getName());
        System.out.println(newFile.getAbsolutePath());

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

//    private void performExtraction(String reportPaths, ProductReport productReport,List<List<String>>rows) throws IOException {
//
//        File excelFile = new File(reportPaths);
//        FileInputStream fis = new FileInputStream(excelFile);
//
//        // we create an XSSF Workbook object for our XLSX Excel File
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//
//        // we get first sheet
//
//        System.out.println(workbook.getNumberOfSheets());
//
//        XSSFSheet sheet = workbook.getSheetAt(0);
//
//        // we iterate on rows
//        Iterator<Row> rowIt = sheet.iterator();
//
//        int count = 0;
//        while(rowIt.hasNext()) {
//            Row row = rowIt.next();
//
//
//            // iterate on cells for the current row
//            Iterator<Cell> cellIterator = row.cellIterator();
//
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//
//                switch (cell.getCellType()) {
////                    case Cell.CELL_TYPE_STRING:
////                        System.out.print(cell.getStringCellValue() + "\t");
////                        break;
////
////                    case Cell.CELL_TYPE_NUMERIC:
////                        System.out.print(cell.getNumericCellValue() + "\t");
////                        break;
////                    case Cell.CELL_TYPE_BOOLEAN:
////                        System.out.print(cell.getBooleanCellValue() + "\t");
////                        break;
//
//                    default:
//
//                        System.out.print(cell.toString() + ";");
//
//                }
//            }
//
//            count++;
//            System.out.println();
//        }
//
//        System.out.println("Total amount ="+count);
//
//    }
}
