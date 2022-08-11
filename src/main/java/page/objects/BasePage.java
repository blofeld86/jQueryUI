package page.objects;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import test.helpers.WebElementHandler;

@Slf4j
public class BasePage extends WebElementHandler {

    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected Logger log(){return log;}
    protected Select select;

    public BasePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        jse = ((JavascriptExecutor)driver);
        PageFactory.initElements(driver,this);
    }

    public void scrollToElement(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
    }
}
