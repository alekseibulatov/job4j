package ru.job4j.bank;

/**
 * @author aleksei bulatov
 * @version 1
 * @since 09.11.20
 */

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
     *
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User userAccount = findByPassport(passport);
        if (userAccount != null) {
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
     * Метод идещет счет пользователя по реквизитам.
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
     * @return rsl
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.getRequisite() == null
                && (srcAccount.getBalance()) == 0) {
            return rsl;
        } else if (srcPassport == destPassport) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
