package ru.job4j.list;


import java.util.List;
import java.util.HashMap;


public class UserConvert {


    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        for (User i : list) {
           hashMap.put(i.getId(), i);
        }
        return hashMap;
    }
}
