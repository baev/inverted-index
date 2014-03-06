package ru.ifmo.baev.inverted.index;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static ru.ifmo.baev.inverted.index.WordUtils.getSummaryLength;
import static ru.ifmo.baev.inverted.index.WordUtils.splitByTokens;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public class Document {

    private String body;

    private long summaryTermLength;

    private long termCount;

    private String description;

    private Set<String> terms;

    private String id;

    public Document() {
    }

    public Document(String body, String description) {
        init(body, description);
    }

    public void init(String body, String description) {
        this.body = body;
        this.description = description;
        initTerms();
        this.id = UUID.randomUUID().toString();
    }

    private void initTerms() {
        terms = new HashSet<>();
        List<String> tokens = splitByTokens(body);
        terms.addAll(tokens);
        termCount = tokens.size();
        summaryTermLength = getSummaryLength(tokens);
    }

    public String getBody() {
        return body;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getTerms() {
        return terms;
    }

    public String getId() {
        return id;
    }

    public long getTermCount() {
        return termCount;
    }

    public long getSummaryTermLength() {
        return summaryTermLength;
    }
}


