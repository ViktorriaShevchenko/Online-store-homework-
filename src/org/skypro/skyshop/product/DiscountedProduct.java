package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basicPrice, int discountPercent) {
        super(name);
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
