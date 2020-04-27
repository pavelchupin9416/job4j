package ru.job4j.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *Class Group группирует студентов по секциям.
 *@author chupin
 *@since 28.04.2020
 */

public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream().flatMap(unit -> unit.getUnits().stream().map(i -> new Holder(i, unit.getName())))
                     .collect(Collectors.groupingBy(t -> t.key,
                                Collector.of(
                                        HashSet::new,
                                        (set, el) -> set.add(String.valueOf(el.value)),
                                                (left, right) -> { left.addAll(right); return left; }
                                )));
    }


static class Holder {
    String key, value;

    Holder(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
}