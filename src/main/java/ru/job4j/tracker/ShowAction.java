package ru.job4j.tracker;

import java.util.List;

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
        List<Item> allItemArray = tracker.findAll();
        for (int i = 0; i < allItemArray.size(); i++) {
            out.println("Id: " + allItemArray.get(i).getId() + " name: " + allItemArray.get(i).getName());
        }
        return true;
    }
}
