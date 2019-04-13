package model.config;

import static model.config.ExceptionLevel.GLOBAL;

public class GlobalException extends Exception {
    protected ExceptionLevel mExceptionLevel;

    public GlobalException() {
        initExceptionLevel();
    }

    public GlobalException(String content) {
        super(content);
        initExceptionLevel();
    }

    public String getExceptionLevel() {
        return ExceptionLevel.toString(mExceptionLevel);
    }

    protected void initExceptionLevel() {
        mExceptionLevel = GLOBAL;
    }
}
