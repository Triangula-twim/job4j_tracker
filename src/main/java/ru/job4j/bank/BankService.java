package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User key = findByPassport(passport);
        if (key != null) {
            List<Account> accounts = users.get(key);
            if (!accounts.contains(account)) {
                accounts.add(account);
                users.put(key, accounts);
            }
        }
    }

    public User findByPassport(String passport) {
        List<User> rsl = users.keySet().stream().filter(e -> e.getPassport().
                equals(passport)).collect(Collectors.toList());
        return rsl.isEmpty() ? null : rsl.get(0);
    }

    public Account findByRequisite(String passport, String requisite) {
        User key = findByPassport(passport);
        if (key == null) {
            return null;
        }
        List<Account> accounts = users.get(key).stream().filter(e ->
                e.getRequisite().equals(requisite)).
                collect(Collectors.toList());
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null
                || destAccount == null
                || srcAccount.getBalance() < amount) {
            return false;
        }
        double srcBalance = srcAccount.getBalance();
        double destBalance = destAccount.getBalance();
        destBalance += amount;
        srcBalance -= amount;
        srcAccount.setBalance(srcBalance);
        destAccount.setBalance(destBalance);
        return true;
    }
}
