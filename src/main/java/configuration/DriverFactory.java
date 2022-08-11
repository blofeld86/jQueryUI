package configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Objects;

@Slf4j
public class DriverFactory {

    public WebDriver getDriver(Browser browser){
        WebDriver driver = null;
        try{
            switch (browser){
                case CHROME:
                    driver = getChromeDriver();
                    break;
                case FIREFOX:
                    driver = getFirefoxDriver();
                    break;
                case IE:
                    driver = getInternetExplorerDriver();
                    break;
                default:
                    driver = getEdgeDriver();
                    break;
            }
        }catch (NullPointerException e){
            log.error("Please select the browser correctly");
        }
        return driver;
    }

    public Browser getBrowserFromYAML(){
        return Browser.valueOf(YamlReader.getProperties().getBrowser());
    }

    private WebDriver getChromeDriver() {
        log.info("Successfully chosen chrome driver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver getFirefoxDriver() {
        log.info("Successfully chosen firefox driver");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        return new FirefoxDriver(firefoxOptions);
    }

    private WebDriver getInternetExplorerDriver() {
        log.info("Successfully chosen internet explorer driver");
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private WebDriver getEdgeDriver() {
        log.info("Successfully chosen edge driver");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
