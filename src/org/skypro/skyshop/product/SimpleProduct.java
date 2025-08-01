package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0, получено: " + price);
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
