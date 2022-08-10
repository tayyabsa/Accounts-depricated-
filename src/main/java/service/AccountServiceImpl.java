package service;

import dao.AccountBalance;
import dao.User;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Currency;

public class AccountServiceImpl implements AccountServiceApi{

    static {
        balances.put(1, AccountBalance.builder().balance(BigDecimal.ZERO).currency(Currency.getInstance("USD")).user(User.builder().userId(1).name("David").build()).build());
        balances.put(2, AccountBalance.builder().balance(BigDecimal.ZERO).currency(Currency.getInstance("PKR")).user(User.builder().userId(2).name("Tayyab").build()).build());
        balances.put(3, AccountBalance.builder().balance(BigDecimal.ZERO).currency(Currency.getInstance("AED")).user(User.builder().userId(3).name("Michael").build()).build());
    }

    @Override
    public AccountBalance debit(BigDecimal amount, Integer userId) {
        AccountBalance accountBalance = balances.get(userId);
        accountBalance.setBalance(accountBalance.getBalance().subtract(amount, new MathContext(4, RoundingMode.FLOOR)));
        balances.put(userId, accountBalance);
        return accountBalance;
    }

    @Override
    public AccountBalance credit(BigDecimal amount, Integer userId) {
        AccountBalance accountBalance = balances.get(userId);
        accountBalance.setBalance(accountBalance.getBalance().add(amount, new MathContext(4, RoundingMode.FLOOR)));
        balances.put(userId, accountBalance);
        return accountBalance;
    }

    @Override
    public AccountBalance getUserBalance(Integer userId) {
        return balances.get(userId);
    }
}
