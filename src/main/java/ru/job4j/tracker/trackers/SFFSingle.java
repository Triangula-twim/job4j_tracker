package ru.job4j.tracker.trackers;

public class SFFSingle {
    //static final field. Eager loading
    private static final SFFSingle INSTANCE = new SFFSingle();

    private SFFSingle() {
    }

    public static SFFSingle getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        SFFSingle tracker = SFFSingle.getInstance();
    }
}

