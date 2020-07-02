package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "== Edit Item ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Edit Item ==");
        String idNumber = input.askStr("Input ID number for replace");
        String newItem = input.askStr("Input new Item");
        Item item = new Item(newItem);
        if (tracker.replace(idNumber, newItem)) {
            out.println("Item successfully replace.");
        } else {
            out.println("Error replace Item.");
        }
        return true;
    }
}
