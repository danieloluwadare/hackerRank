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


    }
}
