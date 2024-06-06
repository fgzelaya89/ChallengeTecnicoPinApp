package Steps;


import Config.Properties;
import PageObjectModel.HomePage;
import PageObjectModel.ProductListPage;
import PageObjectModel.ProductPage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
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

    @And("Configuración del driver de Chrome")
    public void configuraciónDelDriverDeChrome() {
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




    @When("Se desplazo hacia abajo en la pagina")
    public void iScrollDownThePage() {
        productPage.takeScreenshot(Properties.pathtakeScreenshot);
        productPage.scrollPage();

    }

    @Given("cuando el usuario ingresa home page de MercadoLibre")
    public void cuandoElUsuarioIngresaHomePageDeMercadoLibre() {
        driver.get("https://www.mercadolibre.com.ar/");
    }

    @When("el usuario busca el siguiente producto {string}")
    public void elUsuarioBuscaElSiguienteProducto(String productName) {
        homePage.searchProduct(productName);
    }

    @Then("el usuario observa el siguiente producto {string}")
    public void elUsuarioObservaElSiguienteProducto(String expectedText) {
        productListPage.selectFirstProduct(expectedText);
    }

    @Then("el usuario quiere ver el detalle {string}")
    public void elUsuarioQuiereVerElDetalle(String expectedText) {
        productListPage.selectFirstProductDetail(expectedText);
    }

    @And("selecciona el producto")
    public void seleccionaElProducto() {
        productListPage.selectFirstProduct();
    }

    @Then("el precio del producto es igual a {string}")
    public void elPrecioDelProductoEsIgualA(String expectedPrice) {
        productPage.takeScreenshot(Properties.pathtakeScreenshot);
        productPage.verifyAndAddToCart(expectedPrice);
    }

    @And("valida que contega el siguiente detalle {string}")
    public void validaQueContegaElSiguienteDetalle(String detailText) {
        productPage.takeScreenshot(Properties.pathtakeScreenshot);
        productPage.verifyDetailProduct(detailText);
    }


}
