package Config;


import org.openqa.selenium.WebDriver;

public class Properties {
    public static WebDriver driver;

    public static String pathChromeDriver = System.getProperty("user.dir") + "\\src\\main\\drivers\\chromedriver.exe";
    public static String urlOpenCartHome="https://demo.guru99.com/test/newtours/";//"https://opencart.abstracta.us/";
}
