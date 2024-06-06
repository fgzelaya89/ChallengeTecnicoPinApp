package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected void clickElementwait(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected void closeCookieBanner2() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cookie-consent-banner-opt-out__container")));
            WebElement closeButton = cookieBanner.findElement(By.cssSelector(".cookie-consent-banner-opt-out__action-button"));
            clickElement(closeButton);
        } catch (Exception e) {
            // El banner de cookies no se mostró
        }
    }
    protected void closeCookieBanner() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div[2]/button[1]")));
            clickElement(closeButton);
        } catch (Exception e) {
            // El banner de cookies no se mostró o ya está cerrado
        }
    }
}

