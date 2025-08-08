package org.skypro.skyshop.Exception;

public class BestResultNotFoundException extends Exception {
    public BestResultNotFoundException(String query) {
        super("Не найдено подходящих результатов для запроса: " + query);
    }
}
