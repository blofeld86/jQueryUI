package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DraggablePage extends BasePage {

    @FindBy(id = "draggable")
    private WebElement draggable;


    public DraggablePage(WebDriver driver) { super(driver);}

    @Step("Moving draggable element")
    public DraggablePage moveElement(){
        switchToFrameByIndex(0);
        moveElementByOffSet(draggable, 50,50);
        return this;
    }
}
