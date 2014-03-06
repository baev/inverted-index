package ru.ifmo.baev.inverted.index;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public interface DocumentStorage {

    public void add(Document... documents);

    public Document get(String docid);

    public int size();
}
