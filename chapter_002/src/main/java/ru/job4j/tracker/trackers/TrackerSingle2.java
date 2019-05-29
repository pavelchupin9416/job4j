package ru.job4j.tracker.trackers;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;

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
    private TrackerSingle2() {
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }


    public static void main(String[] args) {
        TrackerSingle2 tracker = TrackerSingle2.getInstance();
    }
}