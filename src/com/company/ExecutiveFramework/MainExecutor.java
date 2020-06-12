package com.company.ExecutiveFramework;

import java.util.ArrayList;
import java.util.List;

public class MainExecutor {
    public static void main(String[] args) {
//        ExecutorsDemo.show();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.toArray());
    }
}
