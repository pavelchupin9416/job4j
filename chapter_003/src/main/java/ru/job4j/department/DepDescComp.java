package ru.job4j.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String o1t = o1;
        String o2t = o2;
        if (o1.indexOf("/") > 0) {
            o1t = o1.substring(0, o1.indexOf("/"));
        }
        if (o2.indexOf("/") > 0) {
            o2t = o2.substring(0, o2.indexOf("/"));
        }
        int rst = o2t.compareTo(o1t);
        if (rst == 0) {
            rst = o1.compareTo(o2);
        }
        return rst;
    }
}