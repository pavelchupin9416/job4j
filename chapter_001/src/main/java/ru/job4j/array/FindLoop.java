package ru.job4j.array;

/**
 *Class FindLoop решение задачи 6.1 поиск индекса в массиве.
 *@author chupin
 *@since 6.03.2019
 */
public class FindLoop {

    /**
     * indexOf - поиск индекса.
     * @param data -  массив чисел.
     * @param el -  искомый элемент.
     * @return rst - индекс.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}