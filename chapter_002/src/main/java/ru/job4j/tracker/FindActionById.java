package ru.job4j.tracker;

import java.util.ArrayList;

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
        ArrayList<Item> id = tracker.findById(idNumber);
        if (id != null) {
            for (Item v : id) {
                out.println(v.getName() + " " + v.getId());
            }
        } else {
            out.println("ID number " + idNumber + " don't exist.");
        }
        return true;
    }
}
