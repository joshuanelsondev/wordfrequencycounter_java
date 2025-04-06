package joshuanelsondev.wordfrequencycounter;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String wordFrequency = countWords("The rain in Spain falls mainly on the plain. The plain is quite dry.");
    }

    public static String countWords(String str) {

        String normalizedText = normalizeString(str);

        String[] words = normalizedText.split(" ");

        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                int wordCount = wordCounts.getOrDefault(word, 0);
                wordCounts.put(word, ++wordCount);
            }
        }

        String mostFrequentWord = null;
        int maxWordFrequency = 0;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxWordFrequency) {
                mostFrequentWord = entry.getKey();
                maxWordFrequency = entry.getValue();
            }
        }

        if (mostFrequentWord != null) {
            System.out.printf("Most used word: '%s'. Number of occurrences: %s", mostFrequentWord, maxWordFrequency);
        } else {
            System.out.println("No valid words found.");
        }


        return "";

    }

    public static String normalizeString (String text) {
        StringBuilder normalizedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                normalizedText.append(Character.toLowerCase(c));
            }
        }

        return normalizedText.toString();
    }
}
