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

import static org.junit.Assert.fail;

public class ProductListPage extends BasePage {

    @FindBy(xpath = "//*[@id=\":R8l5e6:\"]/div[2]/div[2]/a[1]/h2")
    private WebElement firstProduct;

    @FindBy(xpath = "//*[@id=\":R2l5e6:\"]/div[2]/div[1]/a")
    private WebElement firstProductDetail;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void selectFirstProduct(String expectedText) {
        closeCookieBanner(); // Cerrar el banner de cookies si aparece

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(firstProduct));

        if (!firstProduct.getText().equalsIgnoreCase(expectedText)){
            fail("Texto no coincide Actual: " + firstProduct.getText()+ ", Esperado: " + expectedText);
        }

    }
    public void selectFirstProductDetail(String expectedText) {
        closeCookieBanner(); // Cerrar el banner de cookies si aparece

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(firstProductDetail));

        if (!firstProductDetail.getText().equalsIgnoreCase(expectedText)){
            fail("Texto no coincide Actual: " + firstProductDetail.getText()+ ", Esperado: " + expectedText);
        }

        try {
            // Intenta hacer clic directamente en el elemento
            clickElement(firstProductDetail);
        } catch (ElementClickInterceptedException e) {
            // Si el clic es interceptado, intenta hacer clic usando Actions
            Actions actions = new Actions(driver);
            actions.moveToElement(firstProductDetail).click().perform();
        }

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
