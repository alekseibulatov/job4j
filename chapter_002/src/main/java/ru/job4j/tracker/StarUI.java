package ru.job4j.tracker;


public class StarUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("== Create a new Item ==");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItem(Tracker tracker) {
        System.out.println("== Show all Items ==");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            System.out.println(item);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("== Edit Item ==");
        String idNumber = input.askStr("Input ID number for replace");
        String newItem = input.askStr("Input new Item");
        Item item = new Item(newItem);
        if (tracker.replace(idNumber, newItem)) {
            System.out.println("Item successfully replace.");
        } else {
            System.out.println("Error replace Item.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("== Delete Item ==");
        String idNumber = input.askStr("Input ID number for delete");
        if (tracker.delete(idNumber)) {
            System.out.println("Item successfully delete.");
        } else {
            System.out.println("Error delete Item.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("== Find item by ID ==");
        String idNumber = input.askStr("Enter ID: ");
        Item id = tracker.findById(idNumber);
        if (id != null) {
            System.out.println(id);
        } else {
            System.out.println("ID number " + idNumber + " don't exist.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("== Find by Name ==");
        String name = input.askStr("Enter Name: ");
        Item[] findName = tracker.findByName(name);
        if (findName.length > 0) {
            for (int i = 0; i < findName.length; i++) {
                Item itemName = findName[i];
                System.out.println(itemName);
            }
        } else {
            System.out.println("ID name " + name + " don't exist.");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StarUI.createItem(input, tracker);
            } else if (select == 1) {
                StarUI.showAllItem(tracker);
            } else if (select == 2) {
                StarUI.editItem(input, tracker);
            } else if (select == 3) {
                StarUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StarUI.findItemById(input, tracker);
            } else if (select == 5) {
                StarUI.findItemByName(input, tracker);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StarUI().init(input, tracker);
    }
}
