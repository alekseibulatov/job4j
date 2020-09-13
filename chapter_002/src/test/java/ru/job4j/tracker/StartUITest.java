package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;


public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("Replace item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{"0", item.getId(), replacedName, "1"});
        UserAction[] actions = {new EditAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));

    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("Deleted item"));

        Input in = new StubInput(new String[]{"0", item.getId(), "1"});
        UserAction[] actions = {new DeleteAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0."
                + "== Exit ==" + System.lineSeparator()
                + "== Exit ==" + System.lineSeparator()));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        UserAction[] actions = {new ShowAllAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0." + "== Show all Items ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Show all Items ==" + System.lineSeparator()
                + item.getName() + " " + item.getId() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0." + "== Show all Items ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Exit ==" + System.lineSeparator()));
    }

    @Test
    public void whenFindActionById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(new String[]{"0", item.getId(), "1"});
        UserAction[] actions = {new FindActionById(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0." + "== Find item by ID ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Find item by ID ==" + System.lineSeparator()
                + item.getName() + " " + item.getId() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0." + "== Find item by ID ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Exit ==" + System.lineSeparator()));
    }

    @Test
    public void whenFindActionByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(new String[]{"0", item.getName(), "1"});
        UserAction[] actions = {new FindActionByName(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0." + "== Find by Name ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Find by Name ==" + System.lineSeparator()
                + item.getName() + " " + item.getId() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0." + "== Find by Name ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Exit ==" + System.lineSeparator()));
    }
}
