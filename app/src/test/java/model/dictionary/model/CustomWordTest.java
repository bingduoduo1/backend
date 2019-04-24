package model.dictionary.model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CustomWordTest {
    @Test
    public void testWordEqual() {
        BaseWord word1 = new CustomWord("abc", NatureLanguageType.ENGLISH);
        CustomWord word2 = new CustomWord("abc", NatureLanguageType.ENGLISH);
        assertTrue(word1.equals((Object)word2));
        CustomWord word3 = new CustomWord("abdc", NatureLanguageType.ENGLISH);
        assertFalse(word1.equals((Object)word3));
    }

    @Test
    public void testHashcode() {
        BaseWord word = new CustomWord("aeq", NatureLanguageType.ENGLISH);
        int code = word.hashCode();
    }
}
