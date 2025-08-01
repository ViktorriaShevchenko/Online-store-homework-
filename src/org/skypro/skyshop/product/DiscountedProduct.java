package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basicPrice, int discountPercent) {
        super(name);
        if (basicPrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0. Получено: " + basicPrice);
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100%. Получено: " + discountPercent);
        }
        this.basicPrice = basicPrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return (int) (basicPrice * (1 - discountPercent / 100.0));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " руб. (" + discountPercent + "%)";
    }
}
