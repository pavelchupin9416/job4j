package ru.job4j.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rst = o2.split("/")[0].compareTo(o1.split("/")[0]);
        return rst;
    }
}