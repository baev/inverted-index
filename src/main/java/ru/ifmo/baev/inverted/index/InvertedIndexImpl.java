package ru.ifmo.baev.inverted.index;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ru.ifmo.baev.inverted.index.WordUtils.terminize;

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
    public void add(List<Document> documents) {
        for (Document document : documents) {
            add(document);
        }
    }

    @Override
    public void add(Document document) {
        documentStorage.add(document);
        termStorage.update(document);
    }

    @Override
    public List<DocidBlock> find(String request) {
        List<DocidBlock> docidBlocks = new ArrayList<>();
        Set<String> terms = terminize(request);
        for (String term : terms) {
            docidBlocks.add(termStorage.getTerm(term).getDocidBlock());
        }
        return docidBlocks;
    }

    @Override
    public TermStorage getTermStorage() {
        return termStorage;
    }

    @Override
    public DocumentStorage getDocumentStorage() {
        return documentStorage;
    }


}
