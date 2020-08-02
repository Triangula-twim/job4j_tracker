package ru.job4j.tracker.trackers;

import ru.job4j.tracker.Tracker;

public class SFLLSingle {

    //static field. Lazy loading
    private static Tracker instance;

    private SFLLSingle() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
