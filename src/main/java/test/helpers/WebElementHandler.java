package test.helpers;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

@Getter
@Slf4j
public class WebElementHandler {

    private Actions actions;
    private Random random;
    private WebDriverWait wait;

    public WebElementHandler(WebDriver driver){
        actions = new Actions(driver);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
    }

    public void switchToNewWindow(WebDriver driver){
        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            String nextWindow = iterator.next();
            if(!parentWindow.equalsIgnoreCase(nextWindow)){
                driver.switchTo().window(nextWindow);
            }
        }
        log.info("Successfully switched to the new window");
    }

    public void switchAndClosePreviousWindow(WebDriver driver){
        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while(iterator.hasNext()){
            String newWindow = iterator.next();
            if(!parentWindow.equalsIgnoreCase(newWindow)){
                driver.close();
                driver.switchTo().window(newWindow);
            }
        }
        log.info("Successfully switched and closed previous window");
    }

    public void moveElementToElement(WebElement element, WebElement element2){
        getActions().clickAndHold(element).moveToElement(element2).release().perform();
    }

}
