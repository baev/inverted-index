package ru.ifmo.baev.inverted.index;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public class DocidBlock {

    private List<String> docids;

    public DocidBlock() {
        docids = new LinkedList<>();
    }

    public void addDocid(String docid) {
        int i = 0;

        while (i < docids.size() && docids.get(i).compareTo(docid) < 0) {
            i++;
        }

        docids.add(i, docid);
    }

    public List<String> getDocids() {
        return docids;
    }


}
