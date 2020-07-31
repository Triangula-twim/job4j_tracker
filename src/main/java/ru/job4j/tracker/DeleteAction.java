package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ====");
        if (tracker.delete(Integer.valueOf(input.askStr("Choose id what you want to delete: ")))) {
            out.println("Item deleted");
        } else {
            out.println("Item by id not found");
        }
        return true;
    }
}
