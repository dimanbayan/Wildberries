package guru.qa.wildberries;

import guru.qa.wildberries.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static guru.qa.wildberries.TestData.itemCardNumber;
import static guru.qa.wildberries.TestData.notebook;
import static guru.qa.wildberries.pages.components.CatalogComponent.*;
import static io.qameta.allure.Allure.step;

@Feature("Каталог товаров")
@Owner("mumolinda")
public class CatalogTest extends TestBase {
    @Test
    @Story("Пользователь открывает каталог, выбирает интересующую его категорию товаров и просматривает товар")
    @DisplayName("Открытие каталога, выбор категории и открытие первого товара из категории")
    void openItemThroughCatalog() {
        MainPage mainPage = new MainPage();
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Раскрываем каталог и переходим в раздел Электроника -> Ноутбуки", () -> {
            mainPage.chooseSubSectionInCatalog(electronics, notebooksAndComps, notebooks);
        });
        step("Открываем карточку первого товара из списка", () -> {
            mainPage.openFirstItem();
        });
        step("Проверяем, что выбранным товаром является " + notebook, () -> {
            mainPage.checkItemTitle(notebook);
        });
    }

    @Test
    @Story("Пользователь открывает каталог, выбирает интересующую его категорию товаров и добавляет нужный товар в корзину")
    @DisplayName("Открытие каталога, выбор категории, добавление случайного товара в корзину и проверка добавления")
    void openCatalogAndAddItemInCart() {
        MainPage mainPage = new MainPage();
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Раскрываем каталог и переходим в раздел Красота -> Корейская косметика", () -> {
            mainPage.chooseSubSectionInCatalog(beauty, koreanCosmetics);
        });
        step("Добавляем случайный товар из списка в корзину", () -> {
            mainPage.addItemInBasketByNum(itemCardNumber);
        });
        step("Проверяем, что выбранный товар добавлен в корзину", () -> {
            mainPage.checkItemAddedInBasket(itemCardNumber);
        });
    }
}
