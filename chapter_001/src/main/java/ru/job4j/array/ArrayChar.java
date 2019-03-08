package ru.job4j.array;

/**
 *Class ArrayChar решение задачи 6.4 слово начинается с с...
 *@author chupin
 *@since 7.03.2019
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index < value.length; index++) {
            if (value[index] != this.data[index]) {
                result = false;
            }
        }
        return result;
    }
}
