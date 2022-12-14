package cores.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.*;

public class BaseTest {

    WebDriver driver;
    protected final Log log;

    public BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        browserList1 browserList = browserList1.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case CHROME:
                break;
            case FIREFOX:
                break;
            case EDGE:
                break;
            default:
                throw new RuntimeException("Browser name is not  valid");
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected WebDriver getBrowserDrivers(String browserName) {
        browserList1 browserList = browserList1.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case CHROME:
//                WebDriverManager.chromedriver().browserVersion("101.0.4951.67").setup();
                break;
            case FIREFOX:
                break;
            case EDGE:
                break;
            default:
                throw new RuntimeException("Browser name is not  valid");
        }
        driver.manage().window().maximize();
        driver.get(GlobalConstants.LIVE_USER_URL);
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

        return driver;
    }

    protected int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }

    protected boolean VerifyTrue(boolean condition) {
        boolean status = true;
        try {
            assertTrue(condition);
            log.info("---------------------------Passed---------------------------");
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------------False---------------------------");

        }
        return status;
    }

    protected boolean VerifyFalse(boolean condition) {
        boolean status = true;
        try {
            assertFalse(condition);
            log.info("---------------------------Passed---------------------------");

        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------------False---------------------------");

        }
        return status;
    }

    protected boolean VerifyEquals(Object actual, Object expected) {
        boolean status = true;
        try {
            assertEquals(actual, expected);
            log.info("---------------------------Passed---------------------------");

        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------------False---------------------------");

        }
        return status;
    }

    @BeforeSuite
    public void beforSuite() {
        deleteFilesInReportTestNG();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    //Xóa file trong thư mục reportNG ( file chụp ảnh)
    private void deleteFilesInReportTestNG() {
        try {
            File file = new File(GlobalConstants.PEPORTNG_SCREENSHOT_PATH);
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}