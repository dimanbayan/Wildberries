package guru.qa.wildberries;

import guru.qa.wildberries.pages.BasketPage;
import guru.qa.wildberries.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static guru.qa.wildberries.TestData.searchQuery3;
import static io.qameta.allure.Allure.step;

@Feature("Корзина")
@Owner("mumolinda")
public class BasketTest extends TestBase {
    @Test
    @Story("Пользователь ищет товар, добавляет его в корзину и проверяет его наличие в ней")
    @DisplayName("Поиск товара, добавление в корзину и проверка наличия товара в корзине")
    void searchItemAddInCartAndCheckCart() {
        MainPage mainPage = new MainPage();
        BasketPage basketPage = new BasketPage();
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Ищем товар " + searchQuery3, () -> {
            mainPage.setSearchQuery(searchQuery3)
                    .search();
        });
        step("Добавляем первый товар из результатов поиска в корзину", () -> {
            mainPage.saveFirstItemCardNameForBasket()
                    .addItemInBasketByNum(0);
        });
        step("Переходим в корзину", () -> {
            basketPage.openBasket();
        });
        step("Проверяем наличие добавленного товара в корзине", () -> {
            basketPage.checkItemCardInBasketWith(mainPage.getFirstItemCardNameForBasket());
        });
    }

    @Test
    @Story("Пользователь удаляет ненужный товар из корзины")
    @DisplayName("Удаление товара из корзины")
    void deletingItemFromCart() {
        MainPage mainPage = new MainPage();
        BasketPage basketPage = new BasketPage();
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Ищем товар " + searchQuery3, () -> {
            mainPage.setSearchQuery(searchQuery3)
                    .search();
        });
        step("Добавляем первый товар из результатов поиска в корзину", () -> {
            mainPage.addItemInBasketByNum(0);
        });
        step("Переходим в корзину", () -> {
            basketPage.openBasket();
        });
        step("Удаляем товар из корзины", () -> {
            basketPage.deleteItemInList();
        });
        step("Проверяем, что корзина пуста", () -> {
            basketPage.checkBasketIsEmpty();
        });
    }
}
