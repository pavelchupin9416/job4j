
package ru.job4j.calculator;

/**
 *Class Calculator решение задачи 3.1 элементарный калькулятор.
 *@author chupin
 *@since 21.02.2019
 */

public class Calculator {
    private double result;

    /**
     * Add.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtract.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Div.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiple.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * getResult.
     * @return - результат операции.
     */
    public double getResult() {
        return this.result;
    }
}