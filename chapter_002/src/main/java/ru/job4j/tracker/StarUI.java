package ru.job4j.tracker;

import java.util.Scanner;

public class StarUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("== Create a new Item ==");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("== Show all Items ==");
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    Item item = items[i];
                    System.out.println(item);
                }

            } else if (select == 2) {
                System.out.println("== Edit Item ==");
                System.out.println("Input ID number for replace");
                String idNumber = scanner.nextLine();
                System.out.println("Input new Item");
                String newItem = scanner.nextLine();
                Item item = new Item(newItem);
                if (tracker.replace(idNumber, newItem)) {
                    System.out.println("Item successfully replace.");
                } else {
                    System.out.println("Error replace Item.");
                }
            } else if (select == 3) {
                System.out.println("== Delete Item ==");
                System.out.println("Input ID number for delete");
                String idNumber = scanner.nextLine();
                if (tracker.delete(idNumber)) {
                    System.out.println("Item successfully delete.");

                } else {
                    System.out.println("Error delete Item.");
                }
            } else if (select == 4) {
                System.out.println("== Find item by ID ==");
                System.out.println("Enter ID: ");
                String idNumber = scanner.nextLine();
                Item id = tracker.findById(idNumber);
                if (id != null) {
                    System.out.println(id);
                } else {
                    System.out.println("ID number " + idNumber + " don't exist.");
                }

            } else if (select == 5) {
                System.out.println("== Find by Name ==");
                System.out.println("Enter Name: ");
                String name = scanner.nextLine();
                Item[] findName = tracker.findByName(name);
                if (findName.length > 0) {
                    for (int i = 0; i < findName.length; i++) {
                        Item itemName = findName[i];
                        System.out.println(itemName);
                    }
                } else {
                    System.out.println("ID name " + name + " don't exist.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new item.");
        System.out.println("1. Show all item.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by ID.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StarUI().init(scanner, tracker);
    }
}
