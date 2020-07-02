package ru.job4j.tracker;

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
        Item[] findName = tracker.findByName(name);
        if (findName.length > 0) {
            for (int i = 0; i < findName.length; i++) {
                Item itemName = findName[i];
                out.println(itemName);
            }
        } else {
            out.println("ID name " + name + " don't exist.");
        }
        return true;
    }
}
