package ru.ifmo.baev;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public class InvertedIndexImpl implements InvertedIndex {

    private TermStorage termStorage;

    private DocumentStorage documentStorage;

    public InvertedIndexImpl(TermStorage termStorage, DocumentStorage documentStorage) {
        this.termStorage = termStorage;
        this.documentStorage = documentStorage;
    }

    @Override
    public void add(Document document) {
        documentStorage.add(document);
        termStorage.update(document);
    }

    @Override
    public DocidBlock find(String word) {
        return termStorage.getTerm(word).getDocidBlock();
    }
}
