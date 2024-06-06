package Config;


import org.openqa.selenium.WebDriver;

public class Properties {
    public static WebDriver driver;

    public static String pathChromeDriver = System.getProperty("user.dir") + "\\src\\main\\drivers\\chromedriver.exe";
    public static String urlOpenCartHome="https://demo.guru99.com/test/newtours/";//"https://opencart.abstracta.us/";
    public static String pathtakeScreenshot = System.getProperty("user.dir")+"\\src\\test\\resources\\takeScreenshot\\";
    public static final String BASE_URL = "https://petstore.swagger.io/v2";
}
