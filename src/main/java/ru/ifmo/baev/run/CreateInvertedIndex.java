package ru.ifmo.baev.run;

import ru.ifmo.baev.inverted.index.*;

import java.io.IOException;
import java.util.List;

import static ru.ifmo.baev.inverted.index.SerializeUtils.serialize;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 07.03.14
 */
public class CreateInvertedIndex {
    private static final String TEXT_URL = "http://az.lib.ru/t/tolstoj_lew_nikolaewich/text_0080.shtml";

    public static void main(String[] args) throws IOException {
        System.out.println("started...");
        WebDriverHelper helper = new WebDriverHelper();

        List<Document> documents = helper.getDocumentsFrom(TEXT_URL);
        helper.quitDriver();

        DocumentStorage documentStorage = new DocumentStorageImpl();
        TermStorage termStorage = new TermStorageImpl();
        InvertedIndex invertedIndex = new InvertedIndexImpl(termStorage, documentStorage);

        invertedIndex.add(documents);

        long wc = getWordCount(documents);
        System.out.println("Terms count : " + invertedIndex.getTermStorage().size());
        System.out.println("Tokens count: " + wc);
        System.out.println("Average term length: " + invertedIndex.getTermStorage().getAverageTermLength());
        System.out.println("Average token length: " + ((double) getAverageWordLength(documents)) / wc);

        serialize(invertedIndex);
    }

    public static long getWordCount(List<Document> documents) {
        long res = 0;
        for (Document document : documents) {
            res += document.getTermCount();
        }
        return res;
    }

    public static long getAverageWordLength(List<Document> documents) {
        long res = 0;
        for (Document document : documents) {
            res += document.getSummaryTermLength();
        }
        return res;
    }
}
