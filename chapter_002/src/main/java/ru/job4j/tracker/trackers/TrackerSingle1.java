package ru.job4j.tracker.trackers;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;


public enum TrackerSingle1 {
    INSTANCE;

    private Tracker tracker = new Tracker();


    public Item add(Item model) {
        return this.tracker.add(model);
    }

    public List<Item> findAll() {
        return this.tracker.findAll();
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return this.tracker.findByName(key);
    }

    public boolean replace(String id, Item item) {
       return this.tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    public static void main(String[] args) {
        TrackerSingle1 tracker = TrackerSingle1.INSTANCE;
        TrackerSingle1 tracker1 = TrackerSingle1.INSTANCE;
    }
}

