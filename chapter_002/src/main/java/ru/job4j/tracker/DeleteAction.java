package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "== Delete Item ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idNumber = input.askStr("Input ID number for delete");
        if (tracker.delete(idNumber)) {
            System.out.println("Item successfully delete.");
        } else {
            System.out.println("Error delete Item.");
        }
        return true;
    }
}
