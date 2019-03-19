package ru.job4j.array;

import java.util.Arrays;

/**
 *Class ArrayDuplicate решение задачи 6.8 удаление дубликатов в массиве.
 *@author chupin
 *@since 12.03.2019
 */
public class ArrayDuplicate {

    /**
     * remove - удаляет дуюликаты.
     * @param array массив.
     * @return array - массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int end = array.length;
        for (int i = 0; i < end; i++) {
            String word = array[i];
            for (int j = i + 1; j < end; j++) {
                if (word.equals(array[j])) {
                    int shiftLeft = j;
                    for (int k = j + 1; k < end; k++, shiftLeft++) {
                        array[shiftLeft] = array[k];
                    }
                    end--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, end);
    }
}
