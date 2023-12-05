package guru.qa.wildberries.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CatalogComponent {
    SelenideElement burger = $(".nav-element__burger");

    public static SelenideElement
            electronics = $("li[data-menu-id='4830'] > a"),
            notebooksAndComps = $("div[data-menu-id='4830']")
                    .$(".menu-burger__first")
                    .$(withText("Ноутбуки")),
            notebooks = $("div[data-menu-id='4830']")
                    .$(".menu-burger__second")
                    .$(byText("Ноутбуки")),
            beauty = $("li[data-menu-id='543'] > a"),
            koreanCosmetics = $("div[data-menu-id='543']")
                    .$(".menu-burger__first")
                    .$(withText("Корейские бренды"));


    public CatalogComponent openCatalog() {
        burger.click();
        return this;
    }

    public CatalogComponent hoverSection(SelenideElement value) {
        value.hover();
        sleep(1000);
        return this;
    }

    public CatalogComponent chooseSubSection(SelenideElement section) {
        section.click();
        return this;
    }

    public CatalogComponent choose2ndSubSection(SelenideElement firstSubSection, SelenideElement secondSubSection) {
        firstSubSection.click();
        secondSubSection.click();
        return this;
    }
}
