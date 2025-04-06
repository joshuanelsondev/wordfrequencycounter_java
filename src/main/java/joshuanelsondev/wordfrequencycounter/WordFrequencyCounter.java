package joshuanelsondev.wordfrequencycounter;

public class WordFrequencyCounter {
    public static void main(String[] args) {

    }

    public static String countWords(String str) {

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
