package org.skypro.skyshop.search;

import org.skypro.skyshop.Exception.BestResultNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;
    private int capacity;

    public SearchEngine(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительной");
        }
        this.searchables = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public void add(Searchable item) {
        if (searchables.size() < capacity) {
            searchables.add(item);
        } else {
            System.out.println("Поисковый движок заполнен, нельзя добавить элемент.");
        }
    }

    public List<Searchable> search(String query) {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым.");
        }

        List<Searchable> results = new ArrayList<>();

        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
                }
            }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFoundException {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFoundException(search);
        }
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : searchables) {
            if (item == null) { continue; }
            String term = item.getSearchTerm();
            if (term == null) { continue; }
            int count = countSubstringOccurrences(term.toLowerCase(), search.toLowerCase());
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFoundException(search);
        }
        return bestMatch;
    }

    private int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        if (substringLength == 0) {
            return 0;
        }
        while (true) {
            index = str.indexOf(substring, index);
            if (index == -1) {
                break;
            }
            count++;
            index += substringLength;
        }
        return count;
    }
}

