package guru.qa.wildberries;

import guru.qa.wildberries.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static guru.qa.wildberries.TestData.*;
import static io.qameta.allure.Allure.step;

@Feature("Строка поиска товаров")
@Owner("mumolinda")
public class SearchItemTest extends TestBase {
    @Test
    @Story("Пользователь ищет товар через поисковую строку и просматривает его")
    @DisplayName("Поиск товаров по запросу в поисковой строке и проверка релевантности результатов")
    void searchAndOpenItem() {
        MainPage mainPage = new MainPage();
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Ищем товар " + searchQuery1 + " через поисковую строку", () -> {
            mainPage.setSearchQuery(searchQuery1)
                    .search();
        });
        step("Открываем карточку первого товара из результатов поиска", () -> {
            mainPage.openFirstItem();
        });
        step("Проверяем товар на релевантность поисковому запросу", () -> {
            mainPage.checkItemTitle(searchResult1);
        });
    }

    @Test
    @Story("Пользователь ищет товар и использует фильтры для более точного поиска")
    @DisplayName("Поиск товаров, использование фильтра и проверка его применения")
    void searchAndFilterItems() {
        MainPage mainPage = new MainPage();
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Ищем товар " + searchQuery2 + " через поисковую строку", () -> {
            mainPage.setSearchQuery(searchQuery2)
                    .search();
        });
        step("Применяем фильтр по возрастанию цены", () -> {
            mainPage.saveFirstItemCardNameBeforeAction()
                    .filterItemsByPriceAsc();
        });
        step("Проверяем, что фильтр применился", () -> {
            mainPage.saveFirstItemCardNameAfterAction()
                    .checkFilterApplied();
        });
    }


    @Test
    @Story("Пользователь ищет товар по фотографии и просматривает его")
    @DisplayName("Поиск товаров по фотографии и проверка релевантности результатов")
    void searchItemByPhoto() {
        MainPage mainPage = new MainPage();
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Выполняем поиск по фотографии", () -> {
            mainPage.setSearchPhoto(photo);
        });
        step("Открываем карточку первого товара из списка", () -> {
            mainPage.openFirstItem();
        });
        step("Проверяем товар на релевантность поисковому запросу", () -> {
            mainPage.checkItemTitle(searchResultByPhoto);
        });
    }
}
