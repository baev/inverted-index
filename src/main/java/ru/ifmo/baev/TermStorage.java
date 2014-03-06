package ru.ifmo.baev;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public interface TermStorage {

    public void update(Document document);

    public Term getTerm(String word);

}
