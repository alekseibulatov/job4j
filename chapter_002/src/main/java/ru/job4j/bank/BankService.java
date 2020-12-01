package ru.job4j.bank;

import java.util.*;

/**
 * @author aleksei bulatov
 * @version 1
 * @since 09.11.20
 */


public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод  добавляет  пользователя в систему. В методе реализована проверка,
     * что такого пользователя еще нет в системе.
     *
     * @param user, ArrayList<Account>()
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());

    }

    /**
     * Метод добавляет  новый счет к пользователю. В методе реализована проверка,
     * что такого счета у пользователя еще нет.
     *
     * @param passport - паспорт
     * @param account  - счет
     */
    public void addAccount(String passport, Account account) {
        User userAccount = findByPassport(passport);
        if (!users.get(userAccount).contains(account)) {
            users.get(userAccount).add(account);
        }
    }


    /*
     * Метод ищет пользователя по номеру паспорта.
     *
     * @param passport
     * @return userFind
     */
    public User findByPassport(String passport) {
        return users.keySet().
                stream().
                filter(x -> x.getPassport().
                        equals(passport)).
                findFirst().
                orElse(null);
    }

    /*
     * Метод идещет счет пользователя по реквизитам.
     *
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        } else {
            account = users.get(user).
                    stream().
                    filter(x -> x.getRequisite().
                            equals(requisite)).
                    findFirst().orElse(null);
        }
        return account;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте srcAccount
     * (с которого переводят), то метод должен вернуть false.
     *
     * @param srcPassport -паспорт
     * @param srcRequisite - реквизиты с которых переводят деньги
     * @param destPassport - паспорт
     * @param destRequisite - реквезиты куда переводят деньги
     * @param amount - сумма
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
        } else if (srcPassport.equals(destPassport)) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
