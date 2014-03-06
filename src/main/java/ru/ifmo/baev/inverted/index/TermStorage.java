package ru.ifmo.baev.inverted.index;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public interface TermStorage {

    public void update(Document document);

    public Term getTerm(String term);

    public double getAverageTermLength();

    public int size();
}
