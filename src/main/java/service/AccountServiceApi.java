package service;

import dao.AccountBalance;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public interface AccountServiceApi {

    Map<Integer, AccountBalance> balances = new HashMap<>();

    AccountBalance debit(BigDecimal amount, Integer userId);
    AccountBalance credit(BigDecimal amount, Integer userId);
    AccountBalance getUserBalance(Integer userId);
}
