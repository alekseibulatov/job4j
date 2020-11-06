package ru.job4j.bank;

import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;
import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод  добавляет  пользователя в систему. В методе реализована проверка,
     * что такого пользователя еще нет в системе.
     *
     * @param user, ArrayList<Account>()
     */

    public void addUser(User user) {
        if (!user.getPassport().equals(findByPassport(user.getPassport()))) {
            users.put(user, new ArrayList<Account>());
        }
    }

    /**
     * Метод добавляет  новый счет к пользователю. В методе реализована проверка,
     * что такого счета у пользователя еще нет.
     * <p>
     * Первоначально пользователя нужно найти по паспорту. Для этого нужно использовать
     * метод findByPassport.
     * После этого мы получим список всех счетов пользователя и добавим новый счет к ним.
     * В этом методе должна быть проверка, что такого счета у пользователя еще нет.
     *
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
    //    if (users.get(findByPassport(passport)) != null) {
        if (findByPassport(passport) != null) {
            User userAccount = findByPassport(passport);
            users.get(userAccount).add(account);
        } else {
            users.remove(passport, account);
        }
    }



    /**
     * Метод ищет пользователя по номеру паспорта.
     *
     * @param passport
     * @return userFind
     */
    public User findByPassport(String passport) {
        User userFind = null;
        for (User user : users.keySet()) {
            if (user.getPassport() == passport) {
                userFind = user;
            }
        }
        return userFind;
    }

    /**
     * Метод идещет счет пользователя по реквизитам. Сначала нужно найти пользователя.
     * Потом получить список счетов этого пользователя и в нем найти нужный счет.
     *
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        List<Account> list = users.get(findByPassport(passport));
        if (list != null) {
            for (Account a : list) {
                if (a.getRequisite() == requisite) {
                    account = a;
                }
            }
        }
        return account;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте srcAccount
     * (с которого переводят), то метод должен вернуть false.
     *
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = new Account(srcRequisite, amount);
        if (srcAccount.getRequisite() == null && srcAccount.getBalance() == 0) {
            rsl = false;
            return rsl;
        } else
          //  users.putIfAbsent(destPassport, )

        return rsl;
    }
}
