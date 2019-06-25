package ru.job4j.sort;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {

    public int compare(User a, User b) {
        int rst = Integer.compare(a.getName().length(), b.getName().length());
        return rst;
    }
}
