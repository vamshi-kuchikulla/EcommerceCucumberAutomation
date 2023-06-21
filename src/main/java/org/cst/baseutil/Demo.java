package org.cst.baseutil;

import java.util.*;

enum Days {
    MONDAY(01),
    TUESDAY(02),
    WEDNESDAY(03),
    THURSDAY(04);
    private int value;

    Days(int value) {
        this.value = value;
    }
}

public class Demo {
    private enum SEASON {WINTER, SPRING, SUMMER, MONSOON, FALL}

    public Demo() {
        System.out.println(SEASON.MONSOON + ":" + SEASON.FALL);
    }

    public Demo(int i) {

    }

    public static void main(String[] args) {

        Demo d = new Demo();
        Map<String, String> map = Map.of("101", "kvk", "102", "kvr");
        List<String> list = new ArrayList<>(map.keySet());
        for (String s : list) {
            System.out.println(s);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        map.forEach((k, v) -> System.out.println((k + ":" + v)));

        Map<String, String> map1 = Map.ofEntries(
                Map.entry("103", "knr"),
                Map.entry("104", "krr"),
                Map.entry("105", "kmk"));
        String[] keys = map1.keySet().toArray(new String[map1.keySet().size()]);
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
