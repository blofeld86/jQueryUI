package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LandingPage extends BasePage {

    @FindBy(css = "aside:nth-child(1) li")
    private List<WebElement> interactions;

    @FindBy(css = "aside:nth-child(2) li")
    private List<WebElement> widgets;

    @FindBy(css = "aside:nth-child(3) li")
    private List<WebElement> effects;

    @FindBy(css = "aside:nth-child(4) li")
    private List<WebElement> utilities;

    public LandingPage(WebDriver driver) { super(driver);}

    public DraggablePage openDraggable(){
        getWait().until(ExpectedConditions.elementToBeClickable(interactions.get(1)));
        interactions.get(1).click();
        return new DraggablePage(driver);
    }
}
