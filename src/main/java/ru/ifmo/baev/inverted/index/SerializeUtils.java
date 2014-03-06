package ru.ifmo.baev.inverted.index;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 07.03.14
 */
public final class SerializeUtils {

    public static final String DOCUMENT_STORAGE_FILE_NAME = "document-storage.json";

    public static final String TERM_STORAGE_FILE_NAME = "term-storage.json";

    private SerializeUtils() {
    }

    public static void serialize(InvertedIndex invertedIndex) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(DOCUMENT_STORAGE_FILE_NAME), invertedIndex.getDocumentStorage());
        mapper.writeValue(new File(TERM_STORAGE_FILE_NAME), invertedIndex.getTermStorage());
    }

    public static InvertedIndex deserialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentStorage ds = mapper.readValue(new File("document-storage.json"), DocumentStorageImpl.class);
        TermStorage ts = mapper.readValue(new File("term-storage.json"), TermStorageImpl.class);
        return new InvertedIndexImpl(ts, ds);
    }
}
