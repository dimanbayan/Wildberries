package guru.qa.wildberries;

import guru.qa.wildberries.pages.MainPage;
import org.junit.jupiter.api.Test;

import static guru.qa.wildberries.TestData.itemCardNumber;
import static guru.qa.wildberries.TestData.notebook;
import static guru.qa.wildberries.pages.components.CatalogComponent.*;

public class CatalogTest extends TestBase {
    @Test
    void openItemThroughCatalog() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .chooseSubSectionInCatalog(electronics, notebooksAndComps, notebooks)
                .openFirstItem()
                .checkItemTitle(notebook);
    }

    @Test
    void openCatalogAndAddItemInCart() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .chooseSubSectionInCatalog(beauty, koreanCosmetics)
                .addItemInBasketByNum(itemCardNumber)
                .checkItemAddedInBasket(itemCardNumber);
    }
}
