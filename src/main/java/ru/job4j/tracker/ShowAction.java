package ru.job4j.tracker;

public class ShowAction implements UserAction{
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show Item ====");
        Item[] allItemArray = tracker.findAll();
        for (int i = 0; i < allItemArray.length; i++) {
            out.println("Id: " + allItemArray[i].getId() + " name: " + allItemArray[i].getName());
        }
        return true;
    }
}
