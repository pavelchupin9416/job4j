package ru.job4j.array;

/**
 *Class Square решение задачи 6.0 заполнение массива степенями.
 *@author chupin
 *@since 5.03.2019
 */
public class Square {

    /**
     * calculate - создание массива степеней.
     * @param bound -  размер массива.
     * @return rst - массив степеней.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}