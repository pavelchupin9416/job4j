package ru.job4j.condition;

/**
 *Class Point вычесление растояния между точками.
 *@author chupin
 *@since 22.02.2019
 */
public class Point {
    private int x;
    private int y;

    /**
     * Point - конструктор.
     * @param x -  первая кордината.
     * @param y - вторая кордината.
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distanceTo - вычисление дистанции.
     * @param that -  точка.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    /**
     * Main.
     * @param args - args.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }

}