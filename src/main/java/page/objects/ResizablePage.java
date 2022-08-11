package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResizablePage extends BasePage{

    @FindBy(css = "#resizable .ui-icon")
    private WebElement resizable;

    public ResizablePage(WebDriver driver) { super(driver);}

    public ResizablePage resizeSquare(){
       switchToFrameByIndex(0);
       moveElementByOffSet(resizable,50,50);
       return new ResizablePage(driver);
    }


}
