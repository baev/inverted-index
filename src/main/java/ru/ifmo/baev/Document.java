package ru.ifmo.baev;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 03.03.14
 */
public class Document {

    private String body;

    private String description;

    private Set<String> words;

    private String id;

    public Document(String body, String description) {
        this.body = body;
        this.description = description;
        initWords();
        this.id = UUID.randomUUID().toString();
    }

    private void initWords() {
        words = new HashSet<>();
        words.addAll(Arrays.asList(body.split("[^а-яА-Яa-zA-Z]+")));
    }

    public String getBody() {
        return body;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getWords() {
        return words;
    }

    public String getId() {
        return id;
    }
}
