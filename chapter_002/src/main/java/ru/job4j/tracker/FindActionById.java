package ru.job4j.tracker;

public class FindActionById implements UserAction {
    private final Output out;

    public FindActionById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "== Find item by ID ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Find item by ID ==");
        String idNumber = input.askStr("Enter ID: ");
        Item id = tracker.findById(idNumber);
        if (id != null) {
            out.println(id);
        } else {
            out.println("ID number " + idNumber + " don't exist.");
        }
        return true;
    }
}
