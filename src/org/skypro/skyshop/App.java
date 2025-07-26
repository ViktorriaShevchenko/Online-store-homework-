package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        SimpleProduct coffee = new SimpleProduct("Кофе", 250);
        SimpleProduct bread = new SimpleProduct("Хлеб", 75);
        SimpleProduct milk = new SimpleProduct("Молоко", 135);
        FixPriceProduct  banana = new FixPriceProduct ("Бананы");
        FixPriceProduct  eggs = new FixPriceProduct ("Яйца");
        DiscountedProduct wine = new DiscountedProduct("Вино", 1200, 15);
        DiscountedProduct chocolate = new DiscountedProduct("Шоколад", 150, 20);

        Article eggArticle = new Article("Как выбрать яйца", "Категории яиц и их различия");
        Article wineArticle = new Article("Вина для начинающих", "Как подобрать вино к блюду");
        Article foodArticle = new Article("Правильное питание", "Советы для похудения и здорового образа жизни");

        ProductBasket basket = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(chocolate);
        searchEngine.add(milk);
        searchEngine.add(banana);
        searchEngine.add(bread);
        searchEngine.add(eggs);
        searchEngine.add(wine);
        searchEngine.add(coffee);

        searchEngine.add(eggArticle);
        searchEngine.add(wineArticle);
        searchEngine.add(foodArticle);

        ProductBasket.separation();
        System.out.println("Добавление продуктов в корзину");
        ProductBasket.separation();
        basket.addProduct(coffee);
        basket.addProduct(wine);
        basket.addProduct(eggs);
        basket.printBasket();

        ProductBasket.separation();
        System.out.println("Тестирование поисковой системы: ");
        System.out.println("Результаты поиска 'яйца': ");
        Searchable[] eggResult = searchEngine.search("яйца");
        printSearchResult(eggResult);
        System.out.println("Результаты поиска 'вино': ");
        Searchable[] wineResult = searchEngine.search("вино");
        printSearchResult(wineResult);
        ProductBasket.separation();
        System.out.println("Попытка переполнения корзины");
        basket.addProduct(milk);
        basket.addProduct(banana);
        basket.addProduct(coffee);
        ProductBasket.separation();

        System.out.println("Поиск продуктов");
        System.out.println("Есть ли яйца в корзине? " + basket.containsProduct("Яйца"));
        System.out.println("Есть ли рыба в корзине? " + basket.containsProduct("Рыба"));
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice() + " руб.");
        ProductBasket.separation();
        System.out.println("Очистка корзины ");
        ProductBasket.separation();
        basket.clearBasket();
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice() + " руб.");
        System.out.println("Есть ли яйца после очистки? " + basket.containsProduct("Яйца"));
        ProductBasket.separation();
    }

    private static void printSearchResult(Searchable[] results) {
        if (results == null || results.length == 0) {
            System.out.println("Ничего не найдено");
            return;
        }

        int count = 0;
        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Ничего не найдено");
        }
    }
}