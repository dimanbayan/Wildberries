package guru.qa.wildberries;

import guru.qa.wildberries.pages.MainPage;
import org.junit.jupiter.api.Test;

import static guru.qa.wildberries.TestData.*;

public class SearchItemTest extends TestBase {
    @Test
    void searchAndOpenItem() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .setSearchQuery(searchQuery1)
                .search()
                .openFirstItem()
                .checkItemTitle(searchResult1);
    }

    @Test
    void searchAndFilterItems() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .setSearchQuery(searchQuery2)
                .search()
                .saveFirstItemCardNameBeforeAction()
                .filterItemsByPriceAsc()
                .saveFirstItemCardNameAfterAction()
                .checkFilterApplied();
    }


    @Test
    void searchItemByPhoto() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .setSearchPhoto(photo)
                .waitLoadingPage()
                .openFirstItem()
                .checkItemTitle(searchResultByPhoto);
    }
}
