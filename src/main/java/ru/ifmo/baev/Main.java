package ru.ifmo.baev;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public class Main {

    public static final String TEXT_1 = "text1.txt";

    public static final String TEXT_2 = "text2.txt";

    public static void main(String[] args) throws IOException {
        String text1 = getFileAsString(TEXT_1);
        String text2 = getFileAsString(TEXT_2);

        TermStorage termStorage = new TermStorageImpl();
        DocumentStorage documentStorage = new DocumentStorageImpl();
        InvertedIndexImpl index = new InvertedIndexImpl(termStorage, documentStorage);

        Document document1 = new Document(text1, "text 1");
        Document document2 = new Document(text2, "text 2");

        index.add(document1);
        index.add(document2);

        DocidBlock docidBlock = index.find("раму");

        System.out.println(documentStorage.get(docidBlock.getDocids().get(0)).getBody());

    }

    public static String getFileAsString(String path) throws IOException {
        return IOUtils.toString(ClassLoader.getSystemResourceAsStream(path));
    }

    public static void sout(DocidBlock docidBlock) {
        System.out.println(docidBlock.getDocids());
    }
}
