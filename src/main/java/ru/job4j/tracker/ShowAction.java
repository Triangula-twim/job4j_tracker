package ru.job4j.tracker;

public class ShowAction implements UserAction{
    @Override
    public String name() {
        return "=== Show Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItemArray = tracker.findAll();
        for (int i = 0; i < allItemArray.length; i++) {
            System.out.println("Id: " + allItemArray[i].getId() + " name: " + allItemArray[i].getName());
        }
        return true;
    }
}
