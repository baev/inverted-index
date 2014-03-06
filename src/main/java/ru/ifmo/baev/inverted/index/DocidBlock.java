package ru.ifmo.baev.inverted.index;

import java.util.List;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public interface DocidBlock {

    public void addDocid(String docid);

    public List<String> getDocids();
}
