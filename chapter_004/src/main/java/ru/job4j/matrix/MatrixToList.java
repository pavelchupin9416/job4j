package ru.job4j.matrix;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *Class MatrixToList перевод матрицы в список.
 *@author chupin
 *@since 4.02.2020
 */
public class MatrixToList {
    /**
     * Метод перводит матрицу в список.
     * @param numbers входная матрица.
     */
    List<Integer> matrix(Integer[][] numbers) {
        return Stream.of(numbers).flatMap(Stream::of).collect(Collectors.toList());
    }
}
