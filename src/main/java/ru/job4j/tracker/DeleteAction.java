package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        if (tracker.delete(Integer.valueOf(input.askStr("Choose id what you want to delete: ")))) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Item by id not found");
        }
        return true;
    }
}
