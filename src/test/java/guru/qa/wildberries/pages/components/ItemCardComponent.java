package guru.qa.wildberries.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ItemCardComponent {
    private SelenideElement itemCard = $(".product-card__wrapper");
    public SelenideElement itemCardName = $(".product-card__wrapper").$("a");
    public SelenideElement itemCardNameForBasket = $(".product-card__wrapper").$(".product-card__name");

    String itemCardByNum = ".product-card__wrapper",
            basketBtnByNum = "a.product-card__add-basket";

    private String
            itemNameBeforeAction,
            itemNameAfterAction,
            itemNameForBasket;

    public void setItemNameBeforeAction(String itemNameBeforeFilter) {
        this.itemNameBeforeAction = itemNameBeforeFilter;
    }

    public void setItemNameAfterAction(String itemNameAfterFilter) {
        this.itemNameAfterAction = itemNameAfterFilter;
    }

    public void setItemNameForBasket(String itemNameForBasket) {
        this.itemNameForBasket = itemNameForBasket;
    }

    public String getItemNameBeforeAction() {
        return itemNameBeforeAction;
    }

    public String getItemNameAfterAction() {
        return itemNameAfterAction;
    }

    public String getItemNameForBasket() {
        return itemNameForBasket;
    }

    public ItemCardComponent openFirstItemCard() {
        itemCard.click();
        return this;
    }

    public ItemCardComponent hoverItemByNum(int num) {
        SelenideElement itemCard = $(itemCardByNum, num);
        itemCard.scrollTo().hover();
        return this;
    }

    public ItemCardComponent addItemInBasketThroughCard(int num) {
        SelenideElement addingInBasketBtn = $(basketBtnByNum, num);
        addingInBasketBtn.click();
        return this;
    }

    public ItemCardComponent checkItemInBasketThroughCard(int num) {
        SelenideElement addingInBasketBtn = $(basketBtnByNum, num);
        addingInBasketBtn.shouldHave(text("В корзине"));
        return this;
    }
}
