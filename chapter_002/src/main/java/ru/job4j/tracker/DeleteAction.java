package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "== Delete Item ==";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Delete Item ==");
        String idNumber = input.askStr("Input ID number for delete");
        if (tracker.delete(idNumber)) {
            out.println("Item successfully delete.");
        } else {
            out.println("Error delete Item.");
        }
        return true;
    }
}
