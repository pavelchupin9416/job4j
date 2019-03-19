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
        int j = 0;
        int k = 0;
        for (int i = 0; i < sort.length; i++) {
            if (j == first.length)  {
                sort[i] = second[k];
                k++;
                continue;
            }
            if (k == second.length) {
                sort[i] = first[j];
                j++;
                continue;
            }
            if (first[j] <= second[k]) {
                sort[i] = first[j];
                j++;
            } else {
               sort[i] = second[k];
                   k++;
           }
        }
        return sort;
    }
}
