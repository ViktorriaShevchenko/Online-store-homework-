package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products.add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        if (name == null || name.isBlank()) {
            return removedProducts;
        }

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println("Итого: " + getTotalPrice() + " руб.");
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    public boolean containsProduct(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        return false;
        }

    public void clearBasket() {
        products.clear();
        }

    public int countSpecialProducts() {
        int specialCount = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                specialCount++;
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

