package ru.job4j.tracker.trackers;


import ru.job4j.tracker.Tracker;

public enum EnumSingle {
    INSTANCE;

    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}
