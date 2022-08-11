import io.qameta.allure.*;
import org.testng.annotations.Test;

import static java.lang.System.getProperty;
import static org.assertj.core.api.Assertions.assertThat;
import static page.objects.DroppablePage.getResult;

@Epic("Draggable")
@Feature("jQueryUI")
public class DraggableTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Moving the element from the draggable page")
    @Test
    public void draggableTest() {
        landingPage
                   .openDraggable()
                   .moveElement();
    }
}
