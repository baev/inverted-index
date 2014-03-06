package ru.ifmo.baev.inverted.index;

import java.util.*;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 07.03.14
 */
public final class WordUtils {

    WordUtils() {
    }

    public static long getSummaryLength(Collection<String> strings) {
        long res = 0;
        for (String str : strings) {
            res += str.length();
        }
        return res;
    }

    public static Set<String> terminize(String text) {
        Set<String> results = new HashSet<>();
        results.addAll(splitByTokens(text));
        return results;
    }

    public static List<String> splitByTokens(String text) {
        return Arrays.asList(text
                .trim()
                .toLowerCase()
                .split("[^а-яА-Яa-zA-Z]+")
        );
    }
}
