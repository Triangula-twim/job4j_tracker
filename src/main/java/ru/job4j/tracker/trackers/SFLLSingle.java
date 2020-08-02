package ru.job4j.tracker.trackers;

public class SFLLSingle {

    //static field. Lazy loading
    private static SFLLSingle instance;

    private SFLLSingle() {
    }

    public static SFLLSingle getInstance() {
        if (instance == null) {
            instance = new SFLLSingle();
        }
        return instance;
    }
}
