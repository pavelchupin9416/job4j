package ru.job4j.max;

/**
 * @author Pavel Chupin (pavelchupin94@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * max - выбор максимального числа.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     */

    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * max - выбор максимального числа.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     * @param third - третий аргумент.
     */
    public int max(int first, int second, int third) {
      return this.max(this.max(first, second), third);
    }
}
