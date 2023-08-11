package search;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WBTest {
    @Test
    void successLoginTest(){
        Configuration.holdBrowserOpen = true;

        open("https://www.wildberries.ru/");
        sleep(5000);
        $("[id=\"searchInput\"]").setValue("поводок для собаки");
        $(".search-catalog__btn--search").click();
        $(".product-card__name").shouldHave(text("Игрушка"));
    }
}
