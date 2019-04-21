package ru.job4j.tracker.trackers;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();

    private TrackerSingle3() {
    }

    private Tracker tracker = new Tracker();


    public Item add(Item model) {
        return this.tracker.add(model);
    }

    public Item[] findAll() {
        return this.tracker.findAll();
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }

    public Item[] findByName(String key) {
        return this.tracker.findByName(key);
    }

    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {
        TrackerSingle3 tracker = TrackerSingle3.getInstance();
    }
}