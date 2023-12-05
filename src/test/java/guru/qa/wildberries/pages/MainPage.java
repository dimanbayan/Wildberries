package guru.qa.wildberries.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.wildberries.pages.components.CatalogComponent;
import guru.qa.wildberries.pages.components.ItemCardComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MainPage {

    SelenideElement searchField = $("[id=\"searchInput\"]"),
            searchBtn = $(".search-catalog__btn--search"),
            itemTitle = $(".product-page__header"),
            ratingPriceFilter = $(".filters-block__dropdown")
                    .$("div.dropdown-filter", 1),
            priceFilterAsc = $(".filters-block__dropdown")
                    .$("div.dropdown-filter", 1).$("li.filter__item", 2),
            searchByPhotoBtn = $("label.search-catalog__btn").$("input"),
            searchPhoto = $(".upload-photo-btn").$("input"),
            addInBasketNotification = $(".action-notification__text"),
            counterItemsInBasket = $(".navbar-pc__notify");
    CatalogComponent catalog = new CatalogComponent();
    ItemCardComponent itemCard = new ItemCardComponent();

    // Методы открытия и загрузки страницы
    public MainPage openPage() {
        open("/");
        waitLoadingPage();
        return this;
    }

    public MainPage waitLoadingPage() {
        sleep(5000);
        return this;
    }

    // Методы, связанные с поиском
    public MainPage setSearchQuery(String value) {
        searchField.setValue(value);
        return this;
    }

    public MainPage search() {
        searchBtn.click();
        return this;
    }

    public MainPage setSearchPhoto(String value) {
        searchByPhotoBtn.uploadFromClasspath(value);
        return this;
    }

    // Методы, связанные с карточкой продукта
    public MainPage addItemInBasketByNum(int num) {
        itemCard.hoverItemByNum(num)
                .addItemInBasketThroughCard(num);
        return this;
    }

    public MainPage checkItemAddedInBasket(int num) {
        addInBasketNotification.should(appear);
        counterItemsInBasket.should(appear);
        itemCard.hoverItemByNum(num)
                .checkItemInBasketThroughCard(num);
        return this;
    }

    public MainPage openFirstItem() {
        itemCard.openFirstItemCard();
        return this;
    }

    public MainPage checkItemTitle(String value) {
        itemTitle.shouldHave(text(value));
        return this;
    }

    public MainPage saveFirstItemCardNameBeforeAction() {
        itemCard.hoverItemByNum(0)
                .setItemNameBeforeAction(itemCard.itemCardName.getAttribute("aria-label"));
        return this;
    }

    public MainPage saveFirstItemCardNameAfterAction() {
        itemCard.hoverItemByNum(0)
                .setItemNameAfterAction(itemCard.itemCardName.getAttribute("aria-label"));
        return this;
    }

    public MainPage saveFirstItemCardNameForBasket() {
        itemCard.hoverItemByNum(0)
                .setItemNameForBasket(itemCard.itemCardNameForBasket.getOwnText());
        return this;
    }

    public ItemCardComponent getFirstItemCardNameForBasket() {
        return itemCard;
    }

    //   Методы фильтров
    public MainPage filterItemsByPriceAsc() {
        ratingPriceFilter.click();
        priceFilterAsc.click();
        return this;
    }

    public MainPage checkFilterApplied() {
        assertNotEquals(itemCard.getItemNameBeforeAction(), itemCard.getItemNameAfterAction());
        return this;
    }

    //    Методы каталога
    public MainPage chooseSubSectionInCatalog(SelenideElement hs, SelenideElement css) {
        catalog.openCatalog();
        sleep(5000);
        catalog.hoverSection(hs)
                .hoverSection(hs)
                .chooseSubSection(css);
        waitLoadingPage();
        return this;
    }

    public MainPage chooseSubSectionInCatalog(SelenideElement hs, SelenideElement firstSubSection, SelenideElement secondSubSection) {
        catalog.openCatalog()
                .hoverSection(hs)
                .choose2ndSubSection(firstSubSection, secondSubSection);
        return this;
    }

}
