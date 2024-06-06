package PageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class ProductListPage extends BasePage {

    @FindBy(xpath = "//div[@id=':Rel5e6:']/div[2]/div[2]/a/h2")
    private WebElement firstProduct;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void selectFirstProduct(String expectedText) {
        closeCookieBanner(); // Cerrar el banner de cookies si aparece

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(firstProduct));

        assert getText(firstProduct).equals(expectedText) : "Texto no coincide";

    //   clickElement(firstProduct);
    }

    public void selectFirstProduct() {
        closeCookieBanner(); // Cerrar el banner de cookies si aparece

        // Esperar hasta que el elemento sea visible y clickeable
        wait.until(ExpectedConditions.visibilityOf(firstProduct));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));

        try {
            // Intenta hacer clic directamente en el elemento
            clickElement(firstProduct);
        } catch (ElementClickInterceptedException e) {
            // Si el clic es interceptado, intenta hacer clic usando Actions
            Actions actions = new Actions(driver);
            actions.moveToElement(firstProduct).click().perform();
        }
    }


}
