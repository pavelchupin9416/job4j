package ru.job4j.cashmachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private final int[] values = {10, 5, 2, 1};


    public List<Integer> change(int value, int price) {
        int note = value - price;
       List<Integer> result = new ArrayList<>();
        int r = 0;
        for (int i = 0; i < this.values.length; i++) {
            if (note >= this.values[i]) {
                r = i;
                break;
            }
        }
            int index = r;
            int temp = note;
            int steps = temp / this.values[index];
            List<Integer> list = new ArrayList<>();
            while (index < this.values.length) {
                if (temp >= this.values[index]) {
                    int step = temp / this.values[index];
                    for (int i = 0; i < step; i++) {
                        list.add(this.values[index]);
                    }
                    temp = temp % this.values[index];
                } else {
                    index++;
                }
            }
            result = list;
        return result;
    }
}
