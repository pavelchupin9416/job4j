package ru.job4j.phonedictionary;

import java.util.ArrayList;
import java.util.List;

/**
 *Class PhoneDictionary решение задачи Телефонный справочник на базе ArrayList[#109383].
 *@author chupin
 *@since 16.05.2019
 */


public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person value : persons) {
           if (value.getName().contains(key) || value.getAddress().contains(key) || value.getPhone().contains(key)
           || value.getSurname().contains(key)) {
            result.add(value);
            break;
           }
        }
        return result;
    }
}
