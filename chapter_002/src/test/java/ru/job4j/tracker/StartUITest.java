package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;


public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();


        ArrayList<Item> item1 = tracker.add(new Item("Replace item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{"0", item1.get(0).getId(), replacedName, "1"});
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item1.get(0).getId()).get(0).getName(), is(replacedName));

    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        ArrayList<Item> item = tracker.add(new Item("Deleted item"));
        String id = item.get(0).getId();
        Input in = new StubInput(new String[]{"0", item.get(0).getId(), "1"});
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.get(0).getId()).get(0).getName(), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ExitAction(out));
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
        ArrayList<Item> item = tracker.add(new Item("item"));
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0." + "== Show all Items ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Show all Items ==" + System.lineSeparator()
                //     + item.getName() + " " + item.getId() + System.lineSeparator()
                + item.get(0).getName() + " " + item.get(0).getId() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0." + "== Show all Items ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Exit ==" + System.lineSeparator()));
    }

    @Test
    public void whenFindActionById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        ArrayList<Item> item = tracker.add(new Item("item"));
        Input in = new StubInput(new String[]{"0", item.get(0).getId(), "1"});
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindActionById(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0." + "== Find item by ID ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Find item by ID ==" + System.lineSeparator()
                + item.get(0).getName() + " " + item.get(0).getId() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0." + "== Find item by ID ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Exit ==" + System.lineSeparator()));
    }

    @Test
    public void whenFindActionByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        ArrayList<Item> item = tracker.add(new Item("item"));
        Input in = new StubInput(new String[]{"0", item.get(0).getName(), "1"});
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindActionByName(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0." + "== Find by Name ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Find by Name ==" + System.lineSeparator()
                + item.get(0).getName() + " " + item.get(0).getId() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0." + "== Find by Name ==" + System.lineSeparator()
                + "1." + "== Exit ==" + System.lineSeparator()
                + "== Exit ==" + System.lineSeparator()));
    }
}
