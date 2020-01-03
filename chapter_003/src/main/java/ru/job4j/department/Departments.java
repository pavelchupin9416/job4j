package ru.job4j.department;

/**
 *Class Departments сортирует департаменты.
 *@author chupin
 *@since 2.01.2020
 */
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Departments {

    /**
     * Метод сортирующий главные департаменты по убыванию, а подразделения по возрастанию.
     * @param deps список департаментов с подразделениями.
     */
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start == "") {
                tmp.add(el);
                start = start + el;
                } else {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                }
            }
        }
        ArrayList<String> result = new ArrayList<>(tmp);
        result.sort(Comparator.naturalOrder());
        result.sort(new DepDescComp());
        return result;
    }
}
