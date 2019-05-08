package ru.job4j.cashmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CashMachine {

    private final int[] values;

    public int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int index = 0; index < array.length - 1 - j; index++) {
                if (array[index] < array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }



    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
       boolean check = false;
        if (this.values[this.values.length - 1] > this.values[0]) {
            check = true;
        }
        sort(this.values);
        List<List<Integer>> result = new ArrayList<>();
        int r = 0;
        for (int i = 0; i < this.values.length; i++) {
            if (note >= this.values[i]) {
                r = i;
                break;
            }
        }
        for (int j = r; j < this.values.length; j++) {
            int index = j;
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
            result.add(list);
            for (int k = 0; k < steps - 1; k++) {
            for (int t = 0; t <= k; t++) {
                temp = list.get(t);
                if (temp != this.values[this.values.length - 1]) {
                    int l = 0;
                    for (int i = 0; i < this.values.length; i++) {
                        if (temp == this.values[i]) {
                            l = i + 1;
                            break;
                        }
                    }
                    List<Integer> list1 = new ArrayList<>();
                    while (l < this.values.length) {
                        if (temp >= this.values[l]) {
                            int step = temp / this.values[l];
                            for (int i = 0; i < step; i++) {
                                list1.add(this.values[l]);
                            }
                            temp = temp % this.values[l];
                        } else {
                            l++;
                        }
                    }

                    for (int i = k + 1; i < list.size(); i++) {
                        list1.add(list.get(i));
                    }
                    result.add(list1);
                }
            }
            }

        }
        if (check) {
            for (int i = 0; i < result.size() - 1; i++) {
                List<Integer> temp = result.get(result.size() - 1 - i);
                result.set(result.size() - 1 - i, result.get(i));
                result.set(i, temp);
            }
        }
        return result;

    }
}