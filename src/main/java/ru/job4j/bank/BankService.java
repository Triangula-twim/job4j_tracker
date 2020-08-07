package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User key = findByPassport(passport);
        List<Account> accounts = users.get(key);
        if (!accounts.contains(account)) {
            accounts.add(account);
            users.put(key, accounts);
        }
    }

    public User findByPassport(String passport) {
        for (User key:
             users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = users.get(findByPassport(passport));
        if (accounts != null) {
            int index = accounts.indexOf(new Account(requisite, 0));
            if (index != -1) {
                return accounts.get(index);
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        if (findByPassport(srcPassport) == null
                || srcAccount == null
                || srcAccount.getBalance() < amount) {
            return false;
        }
        Account destAccount = findByRequisite(destPassport, dеstRequisite);
        double srcBalance = srcAccount.getBalance();
        double destBalance = destAccount.getBalance();
        destBalance += amount;
        srcBalance -= amount;
        srcAccount.setBalance(srcBalance);
        destAccount.setBalance(destBalance);
        return true;
    }
}
