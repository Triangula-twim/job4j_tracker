package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> key = findByPassport(passport);
        if (key.isPresent()) {
            List<Account> accounts = users.get(key.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
                users.put(key.get(), accounts);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> key = findByPassport(passport);
        if (key.isEmpty()) {
            return Optional.empty();
        }
        return users.get(key.get()).stream().filter(e ->
                e.getRequisite().equals(requisite))
                .findFirst();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isEmpty()
                || destAccount.isEmpty()
                || srcAccount.get().getBalance() < amount) {
            return false;
        }
        double srcBalance = srcAccount.get().getBalance();
        double destBalance = destAccount.get().getBalance();
        destBalance += amount;
        srcBalance -= amount;
        srcAccount.get().setBalance(srcBalance);
        destAccount.get().setBalance(destBalance);
        return true;
    }
}
