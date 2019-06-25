package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rst = 0;
        for (int i = 0; i < left.length(); i++) {
        if (Character.compare(left.charAt(i), right.charAt(i)) >= 1 || Character.compare(left.charAt(i), right.charAt(i)) <= -1) {
            rst = Character.compare(left.charAt(i), right.charAt(i));
            break;
        }
    }
       if (rst == 0) {
        if (Integer.compare(left.length(), right.length()) == -1) {
            rst = -1;
        } else {
            if (Integer.compare(left.length(), right.length()) == 1) {
                rst = 1;
            }
        }
       }

       return rst;
    }
}