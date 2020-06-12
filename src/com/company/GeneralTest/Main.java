package com.company.GeneralTest;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Integer>  map = new HashMap<>();
        map.put(1,1);
        GenTest genTest = new GenTest(1,map);

        genTest.map.put(2,2);

    }
}
