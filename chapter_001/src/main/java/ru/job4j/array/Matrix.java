package ru.job4j.array;

/**
 *Class Matrix решение задачи 6.6 ссоздание матрицы.
 *@author chupin
 *@since 8.03.2019
 */
public class Matrix {

    /**
     * multiple - создает матрицу.
     * @param size размер матрицы.
     * @return table матрица
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}