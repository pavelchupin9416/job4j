package ru.job4j.tracker.trackers;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingle4 {
    private TrackerSingle4() {
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

    public static TrackerSingle4 getInstance() {
        return Holder.INSTANCE;
    }


    private static final class Holder {
        private static final TrackerSingle4 INSTANCE = new TrackerSingle4();
    }

    public static void main(String[] args) {
        TrackerSingle4 tracker = TrackerSingle4.getInstance();
    }
}