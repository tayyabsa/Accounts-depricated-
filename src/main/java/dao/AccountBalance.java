package dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
@Builder
public class AccountBalance {
    private BigDecimal balance;
    private User user;
    private Currency currency;
}
