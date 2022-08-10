import dao.AccountBalance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import service.AccountServiceApi;
import service.AccountServiceImpl;

import java.math.BigDecimal;

public class AccountServiceImplTest {

    AccountServiceApi accountService = new AccountServiceImpl();

    @Test
    public void increaseBalanceTest() {
        assertEquals(BigDecimal.valueOf(100), accountService.getUserBalance(1).getBalance());
        assertEquals(1, accountService.getUserBalance(1).getUser().getUserId());
    }

    @Test
    public void decreaseBalanceTest() {
        // increasing user balance to 100
        AccountBalance credit = accountService.credit(BigDecimal.valueOf(100), 2);

        //decreasing user balance by 50 to make sure remaining balance is 50
        AccountBalance debit = accountService.debit(BigDecimal.valueOf(50.5506), 2);

        assertEquals(BigDecimal.valueOf(49.44), accountService.getUserBalance(2).getBalance());
        assertEquals(2, accountService.getUserBalance(2).getUser().getUserId());
    }
}
