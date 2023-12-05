package guru.qa.wildberries;

import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    public static String
            searchQuery1 = "пружинка для кошки",
            searchResult1 = "игрушки",
            searchQuery2 = "iphone",
            searchQuery3 = "мармелад",
            photo = "mouse.jpg",
            searchResultByPhoto = "мышь",
            notebook = "ноутбук";


    private static int getRandomInt(int min, int max) { //указываем диапазон
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int itemCardNumber = getRandomInt(0, 15);

}
