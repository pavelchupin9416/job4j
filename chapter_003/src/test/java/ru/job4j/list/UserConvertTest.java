package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class UserConvertTest {
    @Test
    public void mapConvert() {
        UserConvert userConvert = new UserConvert();
        List<User> list = List.of(
                new User(1, "Вася", "Москва"),
                new User(2, "Николай", "Питер")
        );
        HashMap<Integer, User> expect = new HashMap<>();
         expect.put(1, (new User(1, "Вася", "Москва")));
         expect.put(2, (new User(2, "Николай", "Питер")));
        HashMap<Integer, User> result = userConvert.process(list);
        result.equals(expect);
    }
}
