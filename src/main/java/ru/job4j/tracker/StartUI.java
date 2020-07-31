package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
                /*            } else if (...) { */
                /*             Добавить остальные действия системы по меню. */
            }else if (select == 1) {
                Item[] allItemArray = tracker.findAll();
                for (int i = 0; i < allItemArray.length; i++) {
                    System.out.println("Id: " + allItemArray[i].getId() + " name: " + allItemArray[i].getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                int id = Integer.valueOf(input.askStr("Choose id what you want to edit:"));
                Item item = new Item();
                item.setName(input.askStr("Enter new name: "));
                if (tracker.replace(id, item)) {
                    System.out.println("Item changed");
                } else {
                    System.out.println("Item by id not found");
                }
            }else if (select == 3) {
                System.out.println("=== Delete Item ====");
                if (tracker.delete(Integer.valueOf(input.askStr("Choose id what you want to delete: ")))) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Item by id not found");
                }
            }else if (select == 4) {
                System.out.println("=== Find Item dy id ====");
                Item findItem = tracker.findById(Integer.valueOf(input.askStr("Choose id: ")));
                if (findItem != null) {
                    System.out.println("Name: " + findItem.getName());
                } else {
                    System.out.println("Item not found");
                }
            }else if (select == 5) {
                System.out.println("=== Find Item dy name ====");
                Item[] findItemByName = tracker.findByName(input.askStr("Choose name: "));
                if (findItemByName.length > 0) {
                    for (int i = 0; i < findItemByName.length; i++) {
                        System.out.println("Id: " + findItemByName[i].getId());
                    }
                } else {
                    System.out.println("no items find by name.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        /* добавить остальные пункты меню. */
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
