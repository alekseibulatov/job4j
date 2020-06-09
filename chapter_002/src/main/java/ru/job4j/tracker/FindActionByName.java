package ru.job4j.tracker;

public class FindActionByName implements UserAction {
    @Override
    public String name() {
        return "== Find by Name ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
