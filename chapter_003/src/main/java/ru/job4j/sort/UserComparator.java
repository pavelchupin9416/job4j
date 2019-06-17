package ru.job4j.sort;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {

    public int compare(User a, User b) {
        int rst;
        if (a.getName().length() > b.getName().length()) {
            rst = 1;
        } else {
            if (a.getName().length() == b.getName().length()) {
                rst = 0;
            } else {
                rst = -1;
            }
        }
        return rst;
    }
}
