package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows > 0) {
            cells++;
        }
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (int lis1 : list) {
          if (j == cells) {
              j = 0;
              i++;
          }
          array[i][j] = lis1;
          j++;
        }
        return array;
    }


    public List<Integer> convert(List<int[]> list) {

            List<Integer> lists = new ArrayList<>();
            for (int[] i : list) {
                for (int j : i) {
                    lists.add(j);
                }
            }
            return lists;
    }
}