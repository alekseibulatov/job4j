package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "== Show all Items ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Show all Items ==");
        List<Item> items = tracker.findAll();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            out.println(item);
        }
        return true;
    }
}
