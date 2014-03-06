package ru.ifmo.baev.run;

import ru.ifmo.baev.inverted.index.DocidBlock;
import ru.ifmo.baev.inverted.index.InvertedIndex;

import java.io.IOException;
import java.util.List;

import static ru.ifmo.baev.inverted.index.SerializeUtils.deserialize;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 07.03.14
 */
public class Request {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("empty request");
            return;
        }

        InvertedIndex invertedIndex = deserialize();
        List<DocidBlock> docidBlocks = invertedIndex.find(join(args));
        System.out.println(docidBlocks.size());
    }

    public static String join(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s);
        }
        return builder.toString();
    }
}
