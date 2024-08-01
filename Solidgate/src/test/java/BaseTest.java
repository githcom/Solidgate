import com.solidgate.api.endpoints.details.DetailsRequests;
import com.solidgate.api.endpoints.status.StatusRequests;
import com.solidgate.api.endpoints.status.StatusUtils;
import com.solidgate.ui.config.TestConfig;
import com.solidgate.ui.pageobjects.PaymentPage;
import com.solidgate.ui.selenium.DriverManager;
import com.solidgate.ui.selenium.PageObjectManager;
import org.aeonbits.owner.ConfigCache;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public abstract class BaseTest {

    protected static TestConfig config;
    protected static String PAYMENT_PAGE_URL;
    protected PaymentPage paymentPage;
    protected StatusRequests statusRequests;
    protected StatusUtils statusUtils;
    protected DetailsRequests detailsRequests;

    @BeforeAll
    static void setup() {
        config = ConfigCache.getOrCreate(TestConfig.class);
        PAYMENT_PAGE_URL = format("%s/%s", config.hostUrl(),
                config.onetimeEndpoint());
        Awaitility.setDefaultPollInterval(300, TimeUnit.MILLISECONDS);
        Awaitility.setDefaultPollDelay(Duration.ZERO);
        Awaitility.setDefaultTimeout(Duration.ofSeconds(60));
    }

    @BeforeEach
    void prepare() {
        paymentPage = new PageObjectManager(DriverManager.getInstance().getDriver()).getPaymentPage();
        statusRequests = new StatusRequests();
        statusUtils = new StatusUtils(statusRequests);
        detailsRequests = new DetailsRequests();
    }

    @AfterEach
    void close() {
        DriverManager.getInstance().closeDriver();
    }
}
