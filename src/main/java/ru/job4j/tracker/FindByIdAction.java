package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find dy id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item dy id ====");
        Item findItem = tracker.findById(Integer.valueOf(input.askStr("Choose id: ")));
        if (findItem != null) {
            out.println("Name: " + findItem.getName());
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
