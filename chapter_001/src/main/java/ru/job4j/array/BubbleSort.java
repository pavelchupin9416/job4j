package ru.job4j.array;

/**
 *Class BubbleSort решение задачи 6.5 сортировка алгоритмом пузырька.
 *@author chupin
 *@since 8.03.2019
 */
public class BubbleSort {

    /**
     * sort - сортирует массив чисел.
     * @param array массив чисел.
     * @return array отсортированный масив
     */
    public int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int index = 0; index < array.length - 1 - j; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }
}
