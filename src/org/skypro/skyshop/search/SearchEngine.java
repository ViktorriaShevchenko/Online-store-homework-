package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int currentIndex;

    public SearchEngine(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительной");
        }
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex++] = item;
        } else {
            System.out.println("Поисковый движок заполнен, нельзя добавить элемент.");
        }
    }

    public Searchable[] search(String query) {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым.");
        }

        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[foundCount++] = item;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}

