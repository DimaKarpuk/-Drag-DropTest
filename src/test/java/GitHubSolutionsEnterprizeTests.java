import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GitHubSolutionsEnterprizeTests {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1928x1080";  // меняем размер окна браузера
        Configuration.baseUrl = "https://github.com/";
        //Configuration.holdBrowserOpen = true;

    }
    @Test
    void GitSolutionsEnterprise(){
        open("https://github.com");
        //На главной странице GitHub выберите меню Solutions.
        $(Selectors.byTagAndText("button","Solutions")).hover();
        //Solutions -> Enterprize видимый элемент.
        $(Selectors.byTagAndText("a","Enterprise")).shouldBe(visible);
        //Solutions -> Enterprize.
        $(Selectors.byTagAndText("a","Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    }
}
