package ru.job4j.peerreview;



import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Code Review
 * 1. Нет java doc
 * 2. имя пакета не по конвекшену, возможно совпадение имен класса.
 * 3. Не импортирован User
 * 4. В методе addUser  не указан тип объектов в ArrayList.
 * 5. В методе Account getActualAccount не верно указан доступ - private.
 * 6. В методе transfer указан метод transfer  с 2 параметрами, в классе его нет.
 * 7. В методе toString() отсутствует аннотация @Override.
 */

public class Bank {

    private TreeMap<User, ArrayList<Account> treemap = new TreeMap<>();

    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }

    public void delete(User user) {
        this.treemap.remove(user);
    }

    public void add(User user, Account account) {
        this.treemap.get(user).add(account);
    }

    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treemap.get(user);
        return list.get(list.indexOf(account));
    }

    public void deleteAccount(User user, Account account) {
        this.treemap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }

    public boolean transfer(User user1, Account account1,
                            User user2, Account account2, double amount) {
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }

    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}
