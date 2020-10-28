package ru.job4j.tracker;

import java.util.ArrayList;

public class FindActionByName implements UserAction {
    private final Output out;

    public FindActionByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "== Find by Name ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Find by Name ==");
        String name = input.askStr("Enter Name: ");
        ArrayList<Item> findName = tracker.findByName(name);
        if (findName.size() > 0) {
            for (Item m : findName) {
                out.println(m.getName() + " " + m.getId());
            }
        } else {
            out.println("ID name " + name + " don't exist.");
        }
        return true;
    }
}
