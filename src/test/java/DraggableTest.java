import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import page.objects.BasePage;
import page.objects.DraggablePage;

import static java.lang.System.getProperty;
import static org.assertj.core.api.Assertions.assertThat;
import static page.objects.DraggablePage.getResult;

@Epic("Draggable")
@Feature("jQueryUI")
public class DraggableTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Getting the syllabus test")
    @Test
    public void draggableTest() {
        landingPage
                   .openDraggable()
                   .moveElementToDroppable();
        assertThat(getResult())
                               .isNotNull()
                               .isNotEmpty()
                               .isEqualTo(getProperty("droppableInfo"));
    }
}
