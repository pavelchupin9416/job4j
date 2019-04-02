package ru.job4j.paint;

/**
 * Class Paint рисует фигуру в строку.
 * @author chupin
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     * Метод рисует фигуру.
     * @param shape фигура
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        new Paint().draw(new Triangle());
        new Paint().draw(new Square());
    }
}
