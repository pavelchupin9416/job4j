package ru.job4j.loop;

/**
 *Class Board решение задачи 5.3 постройка шахматной доски.
 *@author chupin
 *@since 2.03.2019
 */

public class Board {

    /**
     * Paint - создание доски.
     * @param width - ширина.
     * @param height - высота.
     * @return screen - шахматная доска в строке.
     */

    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}