package ru.job4j.tracker;

public class FindActionById implements UserAction {
    @Override
    public String name() {
        return "== Find item by ID ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idNumber = input.askStr("Enter ID: ");
        Item id = tracker.findById(idNumber);
        if (id != null) {
            System.out.println(id);
        } else {
            System.out.println("ID number " + idNumber + " don't exist.");
        }
        return true;
    }
}
