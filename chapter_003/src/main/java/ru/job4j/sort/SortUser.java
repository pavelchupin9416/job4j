package ru.job4j.sort;
import java.util.*;

/**
 *Class SortUser сортирует list в treeset.
 *@author chupin
 *@since 12.06.2019
 */
public class SortUser {

    public Set<User> sort(List<User> list) {
       /* TreeSet<User> set = new TreeSet<User>();
        for (User i : list) {
            set.add(i);
        }*/
        return new TreeSet(list);
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new UserComparator());
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new UserSortComparator());
        return list;
    }

}
