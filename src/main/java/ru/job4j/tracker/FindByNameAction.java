package ru.job4j.tracker;

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
