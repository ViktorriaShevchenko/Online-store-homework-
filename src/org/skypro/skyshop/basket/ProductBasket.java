package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductsByName(String name) {
        if (name == null || name.isBlank()) {
            return Collections.emptyList();
        }

        List<Product> removed = productsMap.remove(name);
        return removed != null ? removed : Collections.emptyList();
    }

    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        productsMap.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalPrice() + " руб.");
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean containsProduct(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }

    public void clearBasket() {
        productsMap.clear();
        }


    public static void separation() {
        System.out.println();
        System.out.println("=============================");
        System.out.println();
    }
}

