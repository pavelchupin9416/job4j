package ru.job4j.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rst = 0;
        int temp = 0;
        int first = o1.length() > o2.length() ? o2.length() : o1.length();
        for (int i = 0; i < first; i++) {
            if (temp == 0) {
                if (Character.compare(o2.charAt(i), o1.charAt(i)) != 0) {
                    rst = Character.compare(o2.charAt(i), o1.charAt(i));
                    break;
                }
            }
            if (temp == 1) {
                if (Character.compare(o1.charAt(i), o2.charAt(i)) != 0) {
                    rst = Character.compare(o1.charAt(i), o2.charAt(i));
                    break;
                }
            }
            if (String.valueOf(o1.charAt(i)).equals("/")) {
                temp = 1;
            }
        }
        if (rst == 0) {
            rst = Integer.compare(o1.length(), o2.length());
        }
        return rst;
    }
}