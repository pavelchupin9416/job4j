package ru.job4j.array;

/**
 *Class Turn решение задачи 6.2 перевернуть массив.
 *@author chupin
 *@since 7.03.2019
 */
public class Turn {

    /**
     * back - переворот массива.
     * @param array -  массив чисел.
     * @return array - перевернутый массив.
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}