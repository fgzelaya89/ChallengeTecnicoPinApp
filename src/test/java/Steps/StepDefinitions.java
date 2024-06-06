package Steps;


import Config.Properties;
import PageObjectModel.HomePage;
import PageObjectModel.ProductListPage;
import PageObjectModel.ProductPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class StepDefinitions {
    private WebDriver driver;
    private HomePage homePage;
    private ProductListPage productListPage;
    private ProductPage productPage;

    @Before
    public void setUp() {
        // Configuración del driver de Chrome
        System.setProperty("webdriver.chrome.driver", Properties.pathChromeDriver);

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(Properties.pathChromeDriver))
                .withLogOutput(System.out)
                .build();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(service, options);

        homePage = new HomePage(driver);
        productListPage = new ProductListPage(driver);
        productPage = new ProductPage(driver);
    }

    @After
    public void tearDown() {
        // Cerrar el navegador
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the MercadoLibre home page")
    public void iAmOnTheMercadoLibreHomePage() {
        driver.get("https://www.mercadolibre.com.ar/");
    }

    @When("I search for {string}")
    public void iSearchFor(String productName) {
        homePage.searchProduct(productName);
    }

    @Then("I should see the product {string}")
    public void iShouldSeeTheProduct(String expectedText) {
        productListPage.selectFirstProduct(expectedText);
    }

    @When("I select the product")
    public void iSelectTheProduct() {
        productListPage.selectFirstProduct();
    }

    @When("I scroll down the page")
    public void iScrollDownThePage() {
        productPage.scrollPage();
    }

    @Then("I should see the price {string}")
    public void iShouldSeeThePrice(String expectedPrice) {

        productPage.verifyAndAddToCart(expectedPrice);
    }

    @When("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productPage.verifyAndAddToCart("");
    }


}
