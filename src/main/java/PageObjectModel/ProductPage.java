package PageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    @FindBy(css = ".ui-pdp-buy-box-offers__offer-list-item--SELECTED .ui-pdp-price__second-line")
    private WebElement selectedPrice;

    @FindBy(css = ".andes-list__item:nth-child(2) .ui-pdp-price__second-line:nth-child(1) .andes-money-amount__fraction:nth-child(2)")
    private WebElement priceVerification;

    @FindBy(css = "#\\3AR2cq7raj96c4um\\3A > .andes-button__content")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void verifyAndAddToCart(String expectedPrice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectedPrice));
        clickElement(selectedPrice);

        wait.until(ExpectedConditions.visibilityOf(priceVerification));
        assert getText(priceVerification).equals(expectedPrice) : "El precio no coincide";

    }

    public void scrollPage() {
        ((ChromeDriver) driver).executeScript("window.scrollTo(0,165.3333282470703)");
    }
}
