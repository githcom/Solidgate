import com.solidgate.ui.utils.ConsoleUtils;
import com.solidgate.ui.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaymentPageTest extends BaseTest {

    private static int expectedAmount;
    private static String expectedCurrency;

    @Test
    @Order(1)
    void verifySuccessStatusOrderTest() {
        log.info("Hello, to proceed with the test please specify card number");
        var cardNumber = ConsoleUtils.readLine();
        log.info("Please specify expiry date");
        var expiryDate = ConsoleUtils.readLine();
        log.info("Please specify cvv2");
        var cvv2 = ConsoleUtils.readLine();
        log.info("Please specify card holder");
        var cardHolder = ConsoleUtils.readLine();

        paymentPage.navigateTo(PAYMENT_PAGE_URL);

        var appleWallet = detailsRequests.getDetails().getWallets().getApple();
        expectedAmount = StringUtils.removeDotsAndParseToInt(appleWallet.getAmount());
        expectedCurrency = appleWallet.getCurrency();

        paymentPage.switchToEnglish();
        paymentPage.setCardNumber(cardNumber);
        paymentPage.setCardExpiryDate(expiryDate);
        paymentPage.setCvv2(cvv2);
        paymentPage.setCardHolder(cardHolder);
        paymentPage.verifyTermsAndConditionsChecked();
        paymentPage.pay();

        statusUtils.waitUntilSuccessStatus();
        var actualStatus = statusRequests.getStatus().getOrder().getStatus();
        assertThat(actualStatus).isEqualTo("settle_ok");
    }

    @Test
    @Order(2)
    void verifyOrderAmountTest() {
        var actualAmount = statusRequests.getStatus().getOrder().getAmount();
        assertThat(actualAmount).isEqualTo(expectedAmount);
    }

    @Test
    @Order(3)
    void verifyOrderCurrencyTest() {
        var actualCurrency = statusRequests.getStatus().getOrder().getCurrency();
        assertThat(actualCurrency).isEqualTo(expectedCurrency);
    }
}
