package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct coffee = new SimpleProduct("Кофе", 250);
        SimpleProduct bread = new SimpleProduct("Хлеб", 75);
        SimpleProduct milk = new SimpleProduct("Молоко", 135);
        FixPriceProduct  banana = new FixPriceProduct ("Бананы");
        FixPriceProduct  eggs = new FixPriceProduct ("Яйца");
        DiscountedProduct wine = new DiscountedProduct("Вино", 1200, 15);
        DiscountedProduct chocolate = new DiscountedProduct("Шоколад", 150, 20);

        ProductBasket basket = new ProductBasket();

        ProductBasket.separation();
        System.out.println("Добавление продуктов в корзину");
        ProductBasket.separation();
        basket.addProduct(coffee);
        basket.addProduct(wine);
        basket.addProduct(eggs);

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