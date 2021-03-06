package ru.ifmo.baev.inverted.index;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public class DocumentStorageImpl implements DocumentStorage {

    @JsonProperty("storage")
    private Map<String, Document> storage;

    public DocumentStorageImpl() {
        storage = new ConcurrentHashMap<>();
    }

    @Override
    public void add(Document... documents) {
        for (Document document : documents) {
            if (!storage.containsKey(document.getId())) {
                storage.put(document.getId(), document);
            }
        }
    }

    @Override
    public Document get(String docid) {
        return storage.get(docid);
    }

    @Override
    public int size() {
        return storage.size();
    }


}
