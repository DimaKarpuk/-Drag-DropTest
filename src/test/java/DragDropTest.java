import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragDropTest {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1928x1080";  // меняем размер окна браузера
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void DragAndDrop(){
        open("drag_and_drop");

        actions().moveToElement($("#column-a")).clickAndHold()
                .moveToElement($("#column-b")).release().perform();
    }
}
