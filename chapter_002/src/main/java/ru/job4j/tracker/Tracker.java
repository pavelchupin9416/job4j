package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

/**
 * Class Tracker создание класса заявок.
 * @author chupin
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        //this.items[this.position++] = item;
        return item;
    }


    /**
     * Метод заменяющий заявку в массиве.
     * @param item заявка на замену
     * @param id код заявки
     */
   public boolean replace(String id, Item item) {
       boolean result = false;
       for (int index = 0; index != items.size(); index++) {
           if (items.get(index) != null && items.get(index).getId().equals(id)) {
               items.set(index, item);
               items.get(index).setId(id);
                result = true;
                break;
            }
       }
        return result;
    }

    /**
     * Метод удаляет заявку в массиве.
     * @param id код заявки
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != items.size(); index++) {
            if (items.get(index) != null && items.get(index).getId().equals(id)) {
                items.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращает массив заявок.
     */
    public List<Item> findAll() {
       /* Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }*/
        return items;
    }

    /**
     * Метод возращает массив заявок по имени.
     * @param key имя заявки
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();

        for (int index = 0; index != items.size(); index++) {
            if (items.get(index) != null && items.get(index).getName().equals(key)) {
            result.add(items.get(index));
            }
        }
        return result;
    }

    /**
     * Метод возращает заявку по id.
     * @param id код заявки
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;

    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}