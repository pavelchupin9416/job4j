package ru.job4j.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rst = 0;

        int first = o1.length() > o2.length() ? o2.length() : o1.length();
        int temp = o1.indexOf("/") != -1 ? o1.indexOf("/") : first;
        for (int i = 0; i < temp; i++) {
                if (Character.compare(o2.charAt(i), o1.charAt(i)) != 0) {
                    rst = Character.compare(o2.charAt(i), o1.charAt(i));
                    break;
                }
        }
        for (int i = temp; i < first; i++) {
            if (Character.compare(o1.charAt(i), o2.charAt(i)) != 0) {
                rst = Character.compare(o1.charAt(i), o2.charAt(i));
                break;
            }
        }
        if (rst == 0) {
            rst = Integer.compare(o1.length(), o2.length());
        }
        return rst;
    }
}