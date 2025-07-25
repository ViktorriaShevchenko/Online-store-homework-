package org.skypro.skyshop.product;

public final class FixPriceProduct extends Product{
    private final static int FIXED_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE + " руб.";
    }
}
