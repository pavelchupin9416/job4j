package ru.job4j.sort;

import java.util.Comparator;

public class UserSortComparator implements Comparator<User> {
    public int compare(final User left, final User right) {
       final int rst = left.getName().compareTo(right.getName());
       return rst != 0 ? rst : Integer.compare(left.getAge(), right.getAge());
    }
}
