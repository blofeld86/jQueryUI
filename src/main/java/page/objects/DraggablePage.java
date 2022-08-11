package page.objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DraggablePage extends BasePage {

    @FindBy(id = "draggable")
    private WebElement draggable;

    @FindBy(id = "droppable")
    private WebElement droppable;

    @FindBy(css = "#droppable p")
    private WebElement infoResult;


    private static String result;
    public static String getResult(){ return result;}

    public DraggablePage(WebDriver driver) { super(driver);}

    public DraggablePage moveElementToDroppable(){
        switchToFrameByIndex(0);
        moveElementToElement(draggable, droppable);
        result = infoResult.getText();
        return this;
    }
}
