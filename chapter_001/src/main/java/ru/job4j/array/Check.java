package ru.job4j.array;

/**
 *Class Check решение задачи 6.3 массив boolean.
 *@author chupin
 *@since 7.03.2019
 */
public class Check {

    /**
     * mono - проверка массива.
     * @param  data -  массив boolean.
     * @return result - результат проверки.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 1; index < data.length; index++) {
            if (data[index] != data[0]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
