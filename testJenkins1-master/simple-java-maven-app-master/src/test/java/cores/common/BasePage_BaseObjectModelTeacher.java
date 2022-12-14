package cores.common;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage_BaseObjectModelTeacher {
    /**
     * Open url
     *
     * @param url
     */
    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    /**
     * Get Current URL
     *
     * @param driver
     */
    public void getPageUrl(WebDriver driver) {
        driver.getCurrentUrl();
    }

    /**
     * Get Current Page Title
     *
     * @param driver
     */
    public void getPageTitle(WebDriver driver) {
        driver.getTitle();
    }

    /**
     * Get Page Source
     *
     * @param driver
     */
    public void getPageSource(WebDriver driver) {
        driver.getPageSource();
    }

    /**
     * Back to Previous Page
     *
     * @param driver
     */
    public void backPrevious(WebDriver driver) {
        driver.navigate().back();
    }

    /**
     * Forward to next Page
     *
     * @param driver
     */
    public void forwardToNextPage(WebDriver driver) {
        driver.navigate().forward();
    }

    /**
     * Refresh Page
     *
     * @param driver
     */
    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    /**
     * Wait until Alert is Presence
     *
     * @param driver
     */
    public void waitAlertPresence(WebDriver driver) {
        Alert alert = waitForAlertPresence(driver);
    }

    /**
     * Accept Alert
     *
     * @param driver
     */
    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();

    }

    /**
     * Cancel Alert
     *
     * @param driver
     */
    public void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    /**
     * getText Alert
     *
     * @param driver
     * @return
     */
    public String getTextAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    /**
     * Send Key to Alert
     *
     * @param driver
     * @param value
     */
    public void sendKeyAlert(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    /**
     * Switch to Window By ID
     *
     * @param driver
     * @param expectedID
     */
    public void switchToWindowByID(WebDriver driver, String expectedID) {
        Set<String> listID = driver.getWindowHandles();
        for (String id : listID) {
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
            }

        }
    }

    /**
     * Switch to Window By Title
     *
     * @param driver
     * @param expectedTitle
     */
    public void switchtoWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> listID = driver.getWindowHandles();
        for (String id : listID) {
            driver.switchTo().window(id);
            if (driver.getTitle().equals(expectedTitle)) {
                break;
            }

        }

    }

    /**
     * close All Window Without Parent
     *
     * @param driver
     * @param parentID
     */
    public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
        Set<String> listID = driver.getWindowHandles();
        for (String id : listID) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    /**
     * Get Locator
     *
     * @param locator
     * @return
     */
    public By getLocatorByXpath(String locator) {
        return By.xpath(locator);
    }

    /**
     * get 1 Element by Xpath
     *
     * @param driver
     * @param locator
     * @return
     */
    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getLocatorByXpath(locator));

    }

    /**
     * Get List Element
     *
     * @param driver
     * @param locator
     * @return
     */
    public List<WebElement> getListElements(WebDriver driver, String locator) {
        return driver.findElements(getLocatorByXpath(locator));
    }

    /**
     * wait for Element visible
     *
     * @param driver
     * @param locator
     */
    public WebElement waitForElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, timeOutlnSeconds).until(ExpectedConditions.visibilityOf(getWebElement(driver, locator)));
    }

    /**
     * Wait for Element is Clickable
     *
     * @param driver
     * @param locator
     */

    public WebElement waitForElementClickable(WebDriver driver, String locator) {
        return new WebDriverWait(driver, timeOutlnSeconds).until(ExpectedConditions.elementToBeClickable(getWebElement(driver, locator)));
    }

    /**
     * Wait for Element Invisible
     *
     * @param driver
     * @param locator
     */
    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, timeOutlnSeconds).until(ExpectedConditions.visibilityOfElementLocated(getLocatorByXpath(locator)));
    }

    /**
     * Wait alert Presence
     *
     * @param driver
     * @return
     */
    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, timeOutlnSeconds).until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Click to Element
     *
     * @param driver
     * @param locator
     */
    public void clickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator).click();
    }

    /**
     * Click to Checkbox or RadioButton
     *
     * @param driver
     * @param locator
     */
    public void clickToCheckboxOrRadioButton(WebDriver driver, String locator) {
        if (!getWebElement(driver, locator).isSelected()) {
            clickToElement(driver, locator);
        }
    }

    /**
     * Un Click to Checkbox
     *
     * @param driver
     * @param locator
     */
    public void unClickToCheckbox(WebDriver driver, String locator) {
        if (getWebElement(driver, locator).isSelected()) {
            clickToElement(driver, locator);
        }
    }

    /**
     * Send Key to Element
     *
     * @param driver
     * @param locator
     * @param dataValue
     */
    public void sendKeyToElement(WebDriver driver, String locator, String dataValue) {
        waitForElementVisible(driver, locator);
        WebElement element = getWebElement(driver, locator);
        element.clear();
        element.sendKeys(dataValue);
    }

    /**
     * Select Item In Default Dropdown
     *
     * @param driver
     * @param locator
     * @param textValue
     */
    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String textValue) {
        Select select = new Select(getWebElement(driver, locator));
        select.selectByVisibleText(textValue);
    }

    /**
     * get first Selected Text Item in Default Dropdown
     *
     * @param driver
     * @param locator
     * @return
     */
    public String getFirstSelectedTextItem(WebDriver driver, String locator) {
        Select select = new Select(getWebElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Dropdown is Multiple
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        Select select = new Select(getWebElement(driver, locator));
        return select.isMultiple();
    }

    /**
     * Select Item In Custom Dropdown
     *
     * @param driver
     * @param parentLocator
     * @param childrenLocator
     * @param expectedText
     */
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childrenLocator, String expectedText) {
        waitForElementInvisible(driver, parentLocator);
        clickToElement(driver, parentLocator);
        new WebDriverWait(driver, timeOutlnSeconds).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getLocatorByXpath(childrenLocator)));
        List<WebElement> listItem = getListElements(driver, childrenLocator);
        for (WebElement tempElement : listItem) {
            if (tempElement.getText().equals(expectedText)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, childrenLocator));
                tempElement.click();
                break;
            }
        }
    }

    /**
     * Get Attribute Value
     *
     * @param driver
     * @param locator
     * @param attributeValue
     * @return
     */
    public String getAttributeValue(WebDriver driver, String locator, String attributeValue) {
        return getWebElement(driver, locator).getAttribute(attributeValue);
    }

    /**
     * Get Text of Element
     *
     * @param driver
     * @param locator
     * @return
     */
    public String getTextElement(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    /**
     * Get Css Value
     *
     * @param driver
     * @param locator
     * @param cssValue
     * @return
     */
    public String getCssValue(WebDriver driver, String locator, String cssValue) {
        return getWebElement(driver, locator).getCssValue(cssValue);
    }

    /**
     * get Hexa Color from RGBA
     *
     * @param driver
     * @param locator
     * @param cssValue
     * @return
     */
    public String getHeXaColorFromRGBA(WebDriver driver, String locator, String cssValue) {
        String getRGBA = getCssValue(driver, locator, cssValue);
        return Color.fromString(getRGBA).asHex().toLowerCase();
    }

    /**
     * get Element Size
     *
     * @param driver
     * @param locator
     * @return
     */
    public int getElementsSize(WebDriver driver, String locator) {
        return getListElements(driver, locator).size();
    }

    /**
     * Control Displayed
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isControlDisplayed(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isDisplayed();
    }

    /**
     * Control Selected
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isControlSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    /**
     * Control Enabled
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isControlEnabled(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }

    /**
     * Switch to Frame
     *
     * @param driver
     * @param locator
     */
    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getWebElement(driver, locator));
    }

    /**
     * Switch to default Content
     *
     * @param driver
     * @param locator
     */
    public void switchToDefaultContent(WebDriver driver, String locator) {
        driver.switchTo().defaultContent();
    }

    /**
     * double Click by Actions
     *
     * @param driver
     * @param locator
     */
    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
    }

    /**
     * Hover by Actions
     *
     * @param driver
     * @param locator
     */
    public void hoverMouseToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
    }

    /**
     * Right Click By Actions
     *
     * @param driver
     * @param locator
     */
    public void rightClick(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
    }

    /**
     * Drag And Drop by Actions
     *
     * @param driver
     * @param sourceLocator
     * @param targetLocator
     */
    public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
    }

    /**
     * SendKey board By Actions
     *
     * @param driver
     * @param locator
     * @param key
     */
    public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
    }

    /**
     * click to Element By JavaScript
     *
     * @param driver
     * @param locator
     */
    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
    }

    /**
     * Scroll to Element By JS
     *
     * @param driver
     * @param locator
     */
    public void scrollToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    /**
     * Remove Attribute in DOM
     *
     * @param driver
     * @param locator
     * @param attributeValue
     */
    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeValue + "')", getWebElement(driver, locator));
    }

    /**
     * get Validation Message HTML5
     *
     * @param driver
     * @param locator
     * @return
     */
    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }

    private long timeOutlnSeconds = 30;
}
