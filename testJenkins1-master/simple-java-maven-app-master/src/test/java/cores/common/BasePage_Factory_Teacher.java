package cores.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage_Factory_Teacher {
    // Sendkey / GetText/ Click

    public WebElement waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, timeSecond).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, timeSecond).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        waitForElementClickable(driver, element);
        scrollToElementByJS(driver,element);
        element.click();
    }
    public void sendKeyToElement(WebDriver driver, WebElement element, String dataValue) {
        waitForElementVisible(driver,element);
        element.clear();
        element.sendKeys(dataValue);
    }
    public String getTextElement( WebElement element) {
       return element.getText();
    }
    public void scrollToElementByJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void clickToElementByJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
    }
    private long timeSecond = 30;
}
