package dictionary.exception;

import config.ExceptionLevel;
import config.GlobalException;

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
