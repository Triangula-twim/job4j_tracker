package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find Item dy name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] findItemByName = tracker.findByName(input.askStr("Choose name: "));
        boolean rls = false;
        if (findItemByName.length > 0) {
            for (int i = 0; i < findItemByName.length; i++) {
                System.out.println("Id: " + findItemByName[i].getId());
            }
            rls = true;
        } else {
            System.out.println("no items find by name.");
        }
        return rls;
    }
}
