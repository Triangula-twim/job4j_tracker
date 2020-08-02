package ru.job4j.tracker.trackers;

import ru.job4j.tracker.Tracker;

public class SFFSingle {
    //static final field. Eager loading
    private static final Tracker INSTANCE = new Tracker();

    private SFFSingle() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = SFFSingle.getInstance();
    }
}

