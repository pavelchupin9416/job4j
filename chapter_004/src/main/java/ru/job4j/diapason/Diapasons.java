package ru.job4j.diapason;
import java.util.*;
import java.util.function.Function;

/**
 *Class Diapasons подсчет функции.
 *@author chupin
 *@since 3.01.2020
 */
public class Diapasons {
    /**
     * Метод вычисляет значение функции в диапозоне.
     * @param start начало диапозона.
     * @param end конец диапозона.
     * @param func стандартная функия принимает параметр и возвращает значение.
     */
    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result =  new ArrayList<>();
        for (double index = start; index != end; index++) {
            result.add(func.apply(index));
        }
        return result;
    }
}
