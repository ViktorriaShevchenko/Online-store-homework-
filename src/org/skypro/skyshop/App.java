package org.skypro.skyshop;

import org.skypro.skyshop.Exception.BestResultNotFoundException;
import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        try {
            Product test1 = new SimpleProduct(" ", 170);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 1: " + e.getMessage());
        }
        try {
            Product test2 = new SimpleProduct("Тестовый", -50);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2: " + e.getMessage());
        }
        try {
            DiscountedProduct test3 = new DiscountedProduct("тестовый", 1500, 120);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3: " + e.getMessage());
        }

        SimpleProduct coffee = new SimpleProduct("Кофе", 250);
        SimpleProduct coffeCheaper = new SimpleProduct("Кофе в стике", 75);
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
        searchEngine.add(coffeCheaper);
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
        Set<Searchable> eggResult = searchEngine.search("яйца");
        printSearchResult(eggResult);
        System.out.println("Результаты поиска 'вино': ");
        Set<Searchable> wineResult = searchEngine.search("вино");
        printSearchResult(wineResult);
        ProductBasket.separation();

        try {
            System.out.println("Лучшее совпадение 'кофе'");
            Searchable bestCoffee = searchEngine.findBestMatch("кофе");
            System.out.println("Лучший результат: " + bestCoffee.getStringRepresentation());
        } catch (BestResultNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Поиск несуществующего товара 'Цветы'");
            Searchable bestBeer = searchEngine.findBestMatch("пиво");
            System.out.println("Лучший результат: " + bestBeer.getStringRepresentation());
        } catch (BestResultNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage()); // Должно сработать
        }

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

        System.out.println("Удаление продукта по имени 'кофе': ");
        List<Product> removedProducts = basket.removeProductsByName("Кофе");
        if (removedProducts.isEmpty()) {
            System.out.println("Продукт 'кофе' не найден!");
        } else {
            System.out.println("Удаленный продукт: ");
            for (Product product : removedProducts) {
                System.out.println(product);
            }
        }
        System.out.println("Состояние корзины после удаления кофе:");
        basket.printBasket();
        ProductBasket.separation();

        System.out.println("Удаление продукта по имени 'Чай': ");
        removedProducts = basket.removeProductsByName("Чай");
        if (removedProducts.isEmpty()) {
            System.out.println("Продукт 'чай' не найден");
        }
        System.out.println("Состояние корзины после удаления продуктов:");
        basket.printBasket();
        ProductBasket.separation();

        System.out.println("Очистка корзины ");
        ProductBasket.separation();
        basket.clearBasket();
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice() + " руб.");
        System.out.println("Есть ли яйца после очистки? " + basket.containsProduct("Яйца"));
        ProductBasket.separation();
    }

    private static void printSearchResult(Set<Searchable> results) {
        if (results == null || results.isEmpty()) {
            System.out.println("Ничего не найдено");
            return;
        }
        for (Searchable item : results) {
            System.out.println(item.getStringRepresentation());
        }
    }
}