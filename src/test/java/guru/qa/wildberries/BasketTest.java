package guru.qa.wildberries;

import guru.qa.wildberries.pages.BasketPage;
import guru.qa.wildberries.pages.MainPage;
import org.junit.jupiter.api.Test;

import static guru.qa.wildberries.TestData.searchQuery3;

public class BasketTest extends TestBase {
    @Test
    void searchItemAddInCartAndCheckCart() {
        MainPage mainPage = new MainPage();
        BasketPage basketPage = new BasketPage();
        mainPage.openPage()
                .setSearchQuery(searchQuery3)
                .search()
                .saveFirstItemCardNameForBasket()
                .addItemInBasketByNum(0);
        basketPage.openBasket()
                .checkItemCardInBasketWith(mainPage.getFirstItemCardNameForBasket());
    }

    @Test
    void deletingItemFromCart() {
        MainPage mainPage = new MainPage();
        BasketPage basketPage = new BasketPage();
        mainPage.openPage()
                .setSearchQuery(searchQuery3)
                .search()
                .addItemInBasketByNum(0);
        basketPage.openBasket().
                deleteItemInList()
                .checkBasketIsEmpty();

    }
}
