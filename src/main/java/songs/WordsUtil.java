package songs;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 20/04/2016.
 */
public class WordsUtil {
    public static List<String> getWords(String line) {
        List<String> words = new ArrayList<>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(line);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(line.charAt(firstIndex))) {
                words.add(line.substring(firstIndex, lastIndex));
            }
        }

        return words;
    }
}
