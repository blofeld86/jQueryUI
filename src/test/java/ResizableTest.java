import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Resizable")
@Feature("jQueryUI")
public class ResizableTest extends BaseTest{

    @Severity(SeverityLevel.CRITICAL)
    @Description("Resizing the square")
    @Test
    public void resizeTest() {
        landingPage
                   .openResizable()
                   .resizeSquare();
    }
}
