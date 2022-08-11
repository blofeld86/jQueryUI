import io.qameta.allure.*;
import org.testng.annotations.Test;

import static java.lang.System.getProperty;
import static org.assertj.core.api.Assertions.assertThat;
import static page.objects.DroppablePage.getResult;

@Epic("Droppable")
@Feature("jQueryUI")
public class DroppableTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Dropping the element on a droppable page")
    @Test
    public void droppableTest() {
        landingPage
                .openDroppable()
                .moveElementToDroppable();
        assertThat(getResult())
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(getProperty("droppableInfo"));
    }
}
