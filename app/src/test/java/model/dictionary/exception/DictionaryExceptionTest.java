package model.dictionary.exception;

import org.junit.Test;

public class DictionaryExceptionTest {
    @Test
    public void testDictionaryException() {
        DictionaryException e1 = new DictionaryException();
        DictionaryException e2 = new DictionaryException("strange");
    }
}
