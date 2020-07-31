package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "=== Find Item dy id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item findItem = tracker.findById(Integer.valueOf(input.askStr("Choose id: ")));
        boolean rls = false;
        if (findItem != null) {
            System.out.println("Name: " + findItem.getName());
            rls = true;
        } else {
            System.out.println("Item not found");
        }
        return rls;
    }
}
