package guru.qa.wildberries.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.wildberries.pages.components.ItemCardComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    public SelenideElement basketBtn = $(".navbar-pc__icon--basket"),
            itemName = $(".good-info__good-name"),
            firstItemInBasketList = $(".list-item__wrap");


    ItemCardComponent itemCard = new ItemCardComponent();

    public BasketPage openBasket() {
        basketBtn.click();
        return this;
    }

    public void checkItemCardInBasketWith(ItemCardComponent itemCardForCheck) {
        itemCard.setItemNameForBasket(itemCardForCheck.getItemNameForBasket());
        itemName.shouldHave(text(itemCard.getItemNameForBasket()));
    }

    public BasketPage deleteItemInList() {
        firstItemInBasketList.hover().$(byTagAndText("span", "Удалить")).click();
        return this;
    }

    public void checkBasketIsEmpty() {
        $("h1.basket-empty__title").shouldHave(text("В корзине пока пусто"));
    }


}
