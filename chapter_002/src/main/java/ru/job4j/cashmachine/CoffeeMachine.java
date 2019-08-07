package ru.job4j.cashmachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private final int[] values = {10, 5, 2, 1};

    public List<Integer> change(int value, int price) {
        List<Integer> result = new ArrayList<>();
        for (int i : values) {
            while ((value - price) / i > 0) {
                int step = (value - price) / i;
                for (int j = 0; j < step; j++) {
                   result.add(i);
                }
                value = value - i * step;
            }
        }
        return result;
    }
}
