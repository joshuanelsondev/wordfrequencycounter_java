package joshuanelsondev.wordfrequencycounter;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordFrequencyCounterTest {
    @Test
    public void testFindMostUsedWord_emptyString() {
        String result = WordFrequencyCounter.findMostUsedWord("");
        assertEquals("No valid words found.", result);
    }

    @Test
    public void testFindMostUsedWord_singleWord() {
        String result = WordFrequencyCounter.findMostUsedWord("hello");
        assertEquals("Most used word: 'hello'. Number of occurrences: 1.", result);
    }

    @Test
    public void testFindMostUsedWord_multipleWordsNoRepeats() {
        String result = WordFrequencyCounter.findMostUsedWord("the quick brown fox");
        assertEquals("Most used word: 'the'. Number of occurrences: 1.", result);
    }

    @Test
    public void testFindMostUsedWord_repeatedWords() {
        String result = WordFrequencyCounter.findMostUsedWord("the quick brown fox the quick brown fox");
        assertEquals("Most used word: 'the'. Number of occurrences: 2.", result);
    }

    @Test
    public void testFindMostUsedWord_caseInsensitive() {
        String result = WordFrequencyCounter.findMostUsedWord("Brown Fox the Quick");
        assertEquals("Most used word: 'brown'. Number of occurrences: 1.", result);
    }

    @Test
    public void testFindMostUsedWord_withPunctuation() {
        String result = WordFrequencyCounter.findMostUsedWord("Hello, World!");
        assertEquals("Most used word: 'hello'. Number of occurrences: 1.", result);
    }

    @Test
    public void testFindMostUsedWord_numbersAndLetters() {
        String result = WordFrequencyCounter.findMostUsedWord("word1 word2 123 word1");
        assertEquals("Most used word: 'word'. Number of occurrences: 3.", result);
    }

    @Test
    public void testFindMostUsedWord_leadingAndTrailingWhitespace() {
        String result = WordFrequencyCounter.findMostUsedWord(" Hello ");
        assertEquals("Most used word: 'hello'. Number of occurrences: 1.", result);
    }
}
