package ru.job4j.loop;

/**
 *Class Counter решение задачи 5.1 подсчет суммы четных чисел.
 *@author chupin
 *@since 1.03.2019
 */

public class Counter {

    /**
     * Add - суммирование четных чисел в диапозоне.
     * @param start - первый аргумент.
     * @param finish - второй аргумент.
     * @return sum - сумма чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
              sum = sum + i;
            }
        }
        return sum;
    }
}
