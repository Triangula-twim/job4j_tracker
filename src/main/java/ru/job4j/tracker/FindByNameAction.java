package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction{
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find dy name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item dy name ====");
        List<Item> findItemByName = tracker.findByName(input.askStr("Choose name: "));
//        Item[] findItemByName = tracker.findByName(input.askStr("Choose name: "));
        if (findItemByName.size() > 0) {
            for (int i = 0; i < findItemByName.size(); i++) {
                out.println("Id: " + findItemByName.get(i).getId());
            }
        } else {
            out.println("no items find by name.");
        }
        return true;
    }
}
