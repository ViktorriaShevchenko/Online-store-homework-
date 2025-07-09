package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
public class ProductBasket {
    private final Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getPrice() + " руб.");
        }
        System.out.println("Итого: " + getTotalPrice() + " руб.");
    }

    public boolean containsProduct(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(name)) {
                    return true;
                }
            }
        return false;
        }

    public void clearBasket() {
        count = 0;
        }

    public static void separation() {
        System.out.println();
        System.out.println("=============================");
        System.out.println();
    }
}

