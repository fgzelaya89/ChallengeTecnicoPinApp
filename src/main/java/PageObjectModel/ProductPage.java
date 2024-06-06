package PageObjectModel;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;


import java.time.Duration;

public class ProductPage extends BasePage {

    @FindBy(css = ".ui-pdp-buy-box-offers__offer-list-item--SELECTED .ui-pdp-price__second-line")
    private WebElement selectedPrice;

    @FindBy(css = ".andes-list__item:nth-child(2) .ui-pdp-price__second-line:nth-child(1) .andes-money-amount__fraction:nth-child(2)")
    private WebElement priceVerification;

    @FindBy(xpath = "//*[@id='highlighted_specs_features']/section/div[2]")
    private WebElement specsFeatures;

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
        System.out.println(priceVerification.getText());
        System.out.println(expectedPrice);

       if (!priceVerification.getText().equalsIgnoreCase(expectedPrice)){
           fail("El precio no coincide. Actual: " + priceVerification.getText()+ ", Esperado: " + expectedPrice);
       }


    }

    public void verifyDetailProduct(String detailText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(specsFeatures));
        clickElement(specsFeatures);

        wait.until(ExpectedConditions.visibilityOf(specsFeatures));
        System.out.println(specsFeatures.getText());
        System.out.println(detailText);

        if (!specsFeatures.getText().contains(detailText)){
            fail("No encontro detalle. Actual: " + specsFeatures.getText()+ ", Esperado: " + detailText);
        }


    }

    public void scrollPage() {
        ((ChromeDriver) driver).executeScript("window.scrollTo(0,165.3333282470703)");
    }
}
