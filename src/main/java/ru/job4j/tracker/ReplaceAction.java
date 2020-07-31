package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ====");
        int id = Integer.valueOf(input.askStr("Choose id what you want to edit:"));
        Item item = new Item();
        item.setName(input.askStr("Enter new name: "));
        if (tracker.replace(id, item)) {
            System.out.println("Item changed");
        } else {
            System.out.println("Item by id not found");
        }
        return true;
    }
}
