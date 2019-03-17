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
           if (first[j] <= second[k]) {
             sort[i] = first[j];
             if (j < first.length)  {
                 j++;
             }
               if (j == first.length)  {
                 System.arraycopy(second, k, sort, i + 1, second.length - k);
                 break;
             }
           } else {
               sort[i] = second[k];
               if (k < second.length) {
                   k++;
               }
               if (k == second.length) {
                   System.arraycopy(first, j, sort, i + 1, first.length - j);
                   break;
               }
           }
        }
        return sort;
    }
}
