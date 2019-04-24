package model.dictionary.application;

import org.junit.Test;

import model.dictionary.exception.DictionaryException;
import model.dictionary.exception.NotImplementedError;

import static org.junit.Assert.*;

public class GlobalDictionaryTest {
    GlobalDictionary mDictionary = GlobalDictionary.createDictionary();

    @Test
    public void testFuzzyLookUpWord() {
        try {
            mDictionary.fuzzyLookUpWord(null ,null);
        } catch (DictionaryException e) {
            assertEquals(e.getClass(), NotImplementedError.class);
        }
    }

    @Test
    public void testExactLookUpWord(){
        String word = "ls";
        StringBuffer action = new StringBuffer();
        try {
            mDictionary.exactLookUpWord(word, action);
        } catch (DictionaryException e) {
            e.printStackTrace();
        }
        assertEquals(action.toString(), "ls");
    }
}
