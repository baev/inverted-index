package ru.ifmo.baev;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public class TermStorageImpl implements TermStorage {

    private Map<String, Term> storage;

    public TermStorageImpl() {
        storage = new ConcurrentHashMap<>();
    }

    @Override
    public void update(Document document) {
        for (String word : document.getWords()) {
            if (storage.containsKey(word)) {
                Term term = storage.get(word);
                term.matchFound(document.getId());
            } else {
                Term term = new Term(word);
                term.matchFound(document.getId());
                storage.put(word, term);
            }
        }
    }

    @Override
    public Term getTerm(String word) {
        if (!storage.containsKey(word)) {
            return new Term(word);
        }
        return storage.get(word);
    }

}
