package com.company.GeneralTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ParseException {
//        Map<Integer,Integer>  map = new HashMap<>();
//        map.put(1,1);
//        GenTest genTest = new GenTest(1,map);

//        genTest.map.put(2,2);

//        String pattern = "MMM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(new Date());
//        System.out.println(date);

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM/d/yy HH:mm");
        Date formatDedDate = simpleDateFormat2.parse("12/25/18 18:48");
        System.out.println(formatDedDate);

        formatDate("2020-9-2");
        formatDate("2020-9-02");
        formatDate("2020-09-2");
        formatDate("2020-09-02");

        System.out.println("2348178689035".replaceFirst("234","0"));
        System.out.println("2348234689035".replaceFirst("234","0"));
        System.out.println("2348178689035".length());
        System.out.println("08178689035".length());

        System.out.println(formatPhoneNumber("2348178689035"));
        System.out.println(formatPhoneNumber("2348234689035"));
        System.out.println(formatPhoneNumber("08178689035"));

        /**
         *
            : fullName ===> Daniel-Dada====>Daniel
          : fullName ===> Daniel-Dada===> Dada
           : fullPhoneNumber ===> 08178689035-08126551565===>08178689035
         : dateOfBirth ===> 1996-10-23===>1996-10-23
         : ExceptionHandler getOnePipeAlternateAccountUnAv
         */



        checker("Daniel-Dada","Daniel","Dada","08178689035-08126551565",
                "08178689035","1996-10-23","1996-10-23");

    }

    private static void checker(String fullName, String firstName, String lastName,
                                String fullPhoneNumber,String requestMobileNumber,
                                String requestDob, String dateOfBirth){
        if(!fullName.contains(firstName) ||
                !fullName.contains(lastName) ||
                !fullPhoneNumber.contains(requestMobileNumber) || ! requestDob.equalsIgnoreCase(dateOfBirth)
        ){

            System.out.println("failed validation");
            return;
        }

        System.out.println("successful validation");

    }

    private static String formatPhoneNumber(String phoneNumber){
        if(phoneNumber!=null){
            if(phoneNumber.startsWith("234") && phoneNumber.length()==13)
                return phoneNumber.replaceFirst("234","0");
            else
                return phoneNumber;
        }
        return "";
    }

    static String formatDate(String date){
        StringBuilder sb = new StringBuilder();
        String [] dateArray = date.split("-");
        sb.append(dateArray[0]).append("-");
        if ((dateArray[1].length() == 1)) {
            sb.append("0").append(dateArray[1]).append("-");
        } else {
            sb.append(dateArray[1]).append("-");
        }

        if ((dateArray[2].length() == 1)) {
            sb.append("0").append(dateArray[2]);
        } else {
            sb.append(dateArray[2]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
