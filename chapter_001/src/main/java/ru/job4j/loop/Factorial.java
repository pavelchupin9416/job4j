package ru.job4j.loop;

/**
 *Class Counter решение задачи 5.2 вычисление факториала.
 *@author chupin
 *@since 1.03.2019
 */

public class Factorial {

    /**
     * Calc - факториал числа n.
     * @param n - число факториала.
     * @return fact - факториал.
     */
    public int calc(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
