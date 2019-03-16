package ru.job4j.array;

/**
 *Class SortMassiv решение тестовый задачи сортировки 2 массивов в 1.
 *@author chupin
 *@since 16.03.2019
 */
public class SortMassiv {

    /**
     * sortmas - сортирует массивы чисел.
     * @param first массив чисел.
     * @param second массив чисел.
     * @return sortотсортированный масив
     */
    public int[] sortmas(int[] first, int[] second) {
        int[] sort = new int[first.length + second.length];
        System.arraycopy(first, 0, sort, 0, first.length);
        System.arraycopy(second, 0, sort, first.length, second.length);
        BubbleSort bubble = new BubbleSort();
        bubble.sort(sort);
        return sort;
    }
}
