package model.src.dictionary.exception;

import model.src.config.ExceptionLevel;
import model.src.config.GlobalException;

public class DictionaryException extends GlobalException {
    public DictionaryException() {
        super();
    }

    public DictionaryException(String content) {
        super(content);
    }

    @Override
    protected void initExceptionLevel() {
        mExceptionLevel = ExceptionLevel.Dictionary;
    }
}
