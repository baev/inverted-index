package ru.ifmo.baev;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public interface InvertedIndex {

    public void add(Document document);

    public DocidBlock find(String word);


}
