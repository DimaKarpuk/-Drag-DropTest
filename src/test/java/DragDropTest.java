import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTest {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1928x1080";  // меняем размер окна браузера
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        //Configuration.holdBrowserOpen = true;

    }
    @Test
    void dragAndDrop(){
        open("drag_and_drop");
        $(".example").should(appear);

        actions().moveToElement($("#column-a")).clickAndHold()
                .moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));
    }
    @Test
    void secondMethod(){
        open("drag_and_drop");
        $(".example").shouldHave(text("Drag and Drop"));

        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));
    }
}
