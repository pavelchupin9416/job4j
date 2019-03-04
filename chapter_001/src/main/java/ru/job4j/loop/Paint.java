package ru.job4j.loop;
import java.util.function.BiPredicate;

/**
 *Class Paint решение задачи 5.4 постройка пирамиды.
 *@author chupin
 *@since 2.03.2019
 */
public class Paint {

    /**
     * rightTrl - создание правого треугольнка.
     * @param height - высота.
     * @return screen - треугольник в строке.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * leftTrl - создание левого треугольнка.
     * @param height - высота.
     * @return screen - треугольник доска в строке.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Paint - создание пирамиды.
     * @param height - высота.
     * @return screen - пирамида в строке.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}