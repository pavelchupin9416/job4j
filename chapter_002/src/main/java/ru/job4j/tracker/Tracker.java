package ru.job4j.tracker;

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
    private final Item[] items = new Item[100];

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
        this.items[this.position++] = item;
        return item;
    }


    /**
     * Метод заменяющий заявку в массиве.
     * @param item заявка на замену
     * @param id код заявки
     */
   public boolean replace(String id, Item item) {
       boolean result = false;
       for (int index = 0; index != this.position; index++) {
           if (items[index] != null && items[index].getId().equals(id)) {
                items[index] = item;
               items[index].setId(id);
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
        for (int index = 0; index != this.position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, this.position - index);
                result = true;
                this.position--;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращает массив заявок.
     */
    public Item[] findAll() {
       /* Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }*/
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод возращает массив заявок по имени.
     * @param key имя заявки
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int j = 0;
        for (int index = 0; index != this.position; index++) {
            if (items[index] != null && items[index].getName().equals(key)) {
            result[j] = this.items[index];
            j++;
            }
        }
        return Arrays.copyOf(result, j);
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