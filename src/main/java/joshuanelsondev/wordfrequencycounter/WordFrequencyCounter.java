package joshuanelsondev.wordfrequencycounter;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String wordFrequency = findMostUsedWord("The rain in Spain falls mainly on the plain. The plain is quite dry.");
        findMostUsedWord(wordFrequency);
    }

    public static String findMostUsedWord(String str) {

        if (str == null || str.isEmpty()) {
            return "No valid words found.";
        }

        String normalizedText = normalizeString(str);

        String[] words = normalizedText.split(" ");

        String mostFrequentWord = null;
        int maxWordFrequency = 0;

        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                int wordCount = wordCounts.getOrDefault(word, 0);
                if (++wordCount > maxWordFrequency) {
                   mostFrequentWord = word;
                   maxWordFrequency = wordCount;
                   wordCounts.put(word, wordCount);
                }
            }
        }

        if (mostFrequentWord != null) {
            return String.format("Most used word: '%s'. Number of occurrences: %s.", mostFrequentWord, maxWordFrequency);
        }

        return "";
    }

    public static String normalizeString (String text) {
        StringBuilder normalizedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c) || Character.isWhitespace(c)) {
                normalizedText.append(Character.toLowerCase(c));
            }
        }

        return normalizedText.toString();
    }
}
