package page.objects;
import io.qameta.allure.Step;
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

    @Step("Opening draggable page")
    public DraggablePage openDraggable(){
        getWait().until(ExpectedConditions.elementToBeClickable(interactions.get(0)));
        clickObject(interactions.get(0));
        return new DraggablePage(driver);
    }

    @Step("Opening droppable page")
    public DroppablePage openDroppable(){
        getWait().until(ExpectedConditions.elementToBeClickable(interactions.get(1)));
        clickObject(interactions.get(1));
        return new DroppablePage(driver);
    }

    @Step("Opening resizable page")
    public ResizablePage openResizable(){
        getWait().until(ExpectedConditions.elementToBeClickable(interactions.get(2)));
        clickObject(interactions.get(2));
        return new ResizablePage(driver);
    }
}
