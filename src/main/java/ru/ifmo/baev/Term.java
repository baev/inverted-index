package ru.ifmo.baev;

import java.util.UUID;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public class Term {

    private String id;

    private String body;

    private int matchCount;

    private DocidBlock docidBlock;

    public Term(String body) {
        this.body = body;
        this.matchCount = 0;
        this.id = UUID.randomUUID().toString();
        this.docidBlock = new DocidBlockImpl();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public void matchFound(String docid) {
        matchCount++;
        docidBlock.addDocid(docid);
    }

    public String getId() {
        return id;
    }

    public DocidBlock getDocidBlock() {
        return docidBlock;
    }
}
