package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find Item dy name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] findItemByName = tracker.findByName(input.askStr("Choose name: "));
        if (findItemByName.length > 0) {
            for (int i = 0; i < findItemByName.length; i++) {
                System.out.println("Id: " + findItemByName[i].getId());
            }
        } else {
            System.out.println("no items find by name.");
        }
        return true;
    }
}
