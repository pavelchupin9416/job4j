package ru.job4j.bank;


import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class Bank .
 * @author chupin
 * @version $Id$
 * @since 0.1
 */

public class Bank {

    private HashMap<User, ArrayList<Account>> hashmap = new HashMap<>();

    /**
     * addUser - добавить пользователя.
     * @param user -  пользователь.
     */
    public void addUser(User user) {
        this.hashmap.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * deleteUser - удаление пользователя.
     * @param user -  пользователь.
     */
    public void deleteUser(User user) {
        this.hashmap.remove(user);
    }


    /**
     * addAccountToUser - добавление аккаунта.
     * @param  passport -  паспорт.
     * @param  account -  аккаунт.
     */
  /**  public void addAccountToUser(String passport, Account account) {
        for (User key : hashmap.keySet()) {
            if (key.matchPassport(passport)) {
                this.hashmap.get(key).add(account);
            }
        }
    }
*/private User findByPassport(String passport) {
    return  hashmap.keySet().stream().filter(key -> key.matchPassport(passport)).findFirst().orElse(null);
  }
private Account findAccount(String passport, String requisite) {
    Account account = new Account();
    account = this.hashmap.get(findByPassport(passport))
            .stream().filter(ac -> ac.getReqs().equals(requisite))
            .findFirst().orElse(null);
    return account == null ? null : account;
}
    public void addAccountToUser(String passport, Account account) {
      this.hashmap.get(findByPassport(passport)).add(account);
  }
    /**
     * getActualAccount - проверка массива.
     * @param  passport -  паспорт.
     * @param  requisite -  реквизит.
     */
    private Account getActualAccount(String passport, String requisite) {
        return findAccount(passport, requisite);
    }

    /**
     * getUsers - получение пользователей.
     */
    public Set<User> getUsers() {
        return this.hashmap.keySet();
    }

    /**
     * deleteAccountFromUser - удаление аккаунта.
     * @param  passport -  паспорт.
     * @param  account -  аккаунт.
     */
   /* public void deleteAccountFromUser(String passport, Account account) {
        for (User key : hashmap.keySet()) {
            if (key.matchPassport(passport)) {
                this.hashmap.get(key).remove(account);
            }
        }
    }*/
    public void deleteAccountFromUser(String passport, Account account) {
        this.hashmap.get(findByPassport(passport)).remove(account);

    }

    /**
     * getUserAccounts - получить аккаунты.
     * @param   passport -  паспорт.
     * @return list - список аккаунтов.
     */
  /**  public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>(0);
        for (User key : hashmap.keySet()) {
            if (key.matchPassport(passport)) {
                list = this.hashmap.get(key);
            }
        }
        return list;
    }
*/
  public List<Account> getUserAccounts(String passport) {
      List<Account> list = new ArrayList<>(0);
       list = this.hashmap.get(findByPassport(passport));
       return  list;
  }
    /**
     * transferMoney - перевод денег.
     * @param  srcPassport -  паспорт.
     * @param  srcRequisite -  реквизт.
     * @param  destPassport -  паспорт.
     * @param  dstRequisite -  реквизт.
     * @return result - результат проверки.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean src = false;
        boolean dst = false;
        boolean transfer = false;
        Account ac1 = getActualAccount(srcPassport, srcRequisite);
        Account ac2 = getActualAccount(destPassport, dstRequisite);
            if (ac1 != null) {
                src = true;
            }
            if (ac2 != null) {
                dst = true;
            }
        if ((src
                && dst)
                && (ac1.transfer(ac2, amount))) {
            transfer = true;
        }
        return transfer;
    }
}