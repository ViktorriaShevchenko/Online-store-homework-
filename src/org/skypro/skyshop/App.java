package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product coffee = new Product("Кофе", 250);
        Product bread = new Product("Хлеб", 75);
        Product milk = new Product("Молоко", 135);
        Product banana = new Product("Бананы", 150);
        Product eggs = new Product("Яйца", 90);

        ProductBasket basket = new ProductBasket();

        ProductBasket.separation();
        System.out.println("Добавление продуктов в корзину");
        ProductBasket.separation();
        basket.addProduct(coffee);
        basket.addProduct(eggs);
        basket.addProduct(bread);

        basket.printBasket();
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
}