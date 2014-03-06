package ru.ifmo.baev;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public interface DocumentStorage {

    public void add(Document... documents);

    public Document get(String docid);
}
