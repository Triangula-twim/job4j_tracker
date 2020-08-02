package ru.job4j.tracker.trackers;

public class PSFCSingle {
    //private static final class. Lazy loading
    private PSFCSingle() {
    }

    public static PSFCSingle getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final PSFCSingle INSTANCE = new PSFCSingle();
    }

    public static void main(String[] args) {
        PSFCSingle tracker = PSFCSingle.getInstance();
    }
}
