package page.objects;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage {

    @FindBy(id = "draggable")
    private WebElement draggable;

    @FindBy(id = "droppable")
    private WebElement droppable;

    @FindBy(css = "#droppable p")
    private WebElement infoResult;


    private static String result;
    public static String getResult(){ return result;}

    public DroppablePage(WebDriver driver) { super(driver);}


    @Step("Moving draggable element to droppable area")
    public DroppablePage moveElementToDroppable(){
        switchToFrameByIndex(0);
        moveElementToElement(draggable, droppable);
        result = infoResult.getText();
        return this;
    }
}
