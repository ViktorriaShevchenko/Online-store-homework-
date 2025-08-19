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
        int total = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                System.out.println(product.toString());
            }
        }
        System.out.println("Итого: " + getTotalPrice() + " руб.");
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    public boolean containsProduct(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        return productsMap.containsKey(name);
    }

    public void clearBasket() {
        productsMap.clear();
        }

    public int countSpecialProducts() {
        int specialCount = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }

    public static void separation() {
        System.out.println();
        System.out.println("=============================");
        System.out.println();
    }
}

