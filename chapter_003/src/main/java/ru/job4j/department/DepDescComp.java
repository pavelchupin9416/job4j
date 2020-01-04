package ru.job4j.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String o1t = !o1.contains("/") ? o1 : o1.split("/")[0];
        String o2t = !o2.contains("/") ? o2 : o2.split("/")[0];
        return o2t.compareTo(o1t);
    }
}