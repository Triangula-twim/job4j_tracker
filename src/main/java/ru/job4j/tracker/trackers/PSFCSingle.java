package ru.job4j.tracker.trackers;

import ru.job4j.tracker.Tracker;

public class PSFCSingle {
    //private static final class. Lazy loading
    private PSFCSingle() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = PSFCSingle.getInstance();
    }
}
