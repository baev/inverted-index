package ru.ifmo.baev.inverted.index;

import java.util.List;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public interface InvertedIndex {

    public void add(List<Document> documents);

    public void add(Document document);

    public List<DocidBlock> find(String request);

    public TermStorage getTermStorage();

    public DocumentStorage getDocumentStorage();

}
