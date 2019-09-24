import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UncommonFromSentencesTest {

    UncommonFromSentences uncommonFromSentences = new UncommonFromSentences();

    @Test
    void uncommonFromSentences1() {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        String[] result = uncommonFromSentences.uncommonFromSentences(A, B);
        assertEquals("[sweet, sour]", Arrays.toString(result));
    }

    @Test
    void uncommonFromSentences2() {
        String A = "apple apple";
        String B = "banana";
        String[] result = uncommonFromSentences.uncommonFromSentences(A, B);
        assertEquals("[banana]", Arrays.toString(result));
    }
}