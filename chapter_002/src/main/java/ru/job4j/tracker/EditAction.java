package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "== Edit Item ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idNumber = input.askStr("Input ID number for replace");
        String newItem = input.askStr("Input new Item");
        Item item = new Item(newItem);
        if (tracker.replace(idNumber, newItem)) {
            System.out.println("Item successfully replace.");
        } else {
            System.out.println("Error replace Item.");
        }
        return true;
    }
}
