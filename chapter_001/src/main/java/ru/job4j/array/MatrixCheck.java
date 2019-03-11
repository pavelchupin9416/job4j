package ru.job4j.array;

/**
 *Class Matrix решение задачи 6.7 заполнение матрицы и проверка условий true and false.
 *@author chupin
 *@since 9.03.2019
 */
public class MatrixCheck {

    /**
     * mono - проверяет матрицу на условия.
     * @param data матрица.
     * @return result матрица
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean temp = data[0][0];
        boolean temp2 = data[0][data.length - 1];
        for (int index = 0; index < data.length; index++) {
            if (data[index][index] != temp || data[index][data.length - 1 - index] != temp2) {
                result = false;
                break;
            }
       }
        return result;
    }
}