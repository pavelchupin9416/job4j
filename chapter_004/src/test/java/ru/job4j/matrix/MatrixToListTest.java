package ru.job4j.matrix;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void whenMatrixToList() {
            MatrixToList list = new MatrixToList();
           Integer[][] input = {
                    {1, 2},
                    {3, 4}
            };
            List<Integer> expect = list.matrix(input);
            List<Integer> result = Arrays.asList(1, 2, 3, 4);
                    assertThat(result, is(expect));
        }
    }


