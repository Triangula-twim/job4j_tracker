package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
                System.out.println("Choose id what you want to edit:");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = new Item();
                System.out.println("Enter new name: ");
                item.setName(scanner.nextLine());
                tracker.replace(id, item);
            }else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.println("Choose id what you want to delete: ");
                tracker.delete(Integer.valueOf(scanner.nextLine()));
            }else if (select == 4) {
                System.out.println("=== Find Item dy id ====");
                System.out.println("Choose id: ");
                Item findItem = tracker.findById(Integer.valueOf(scanner.nextLine()));
                if (findItem != null) {
                    System.out.println("Name: " + findItem.getName());
                }
            }else if (select == 5) {
                System.out.println("=== Find Item dy name ====");
                System.out.println("Choose name: ");
                Item[] findItemByName = tracker.findByName(scanner.nextLine());
                for (int i = 0; i < findItemByName.length; i++) {
                    System.out.println("Id: " + findItemByName[i].getId());
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
