package model.config;

public enum ExceptionLevel {
    GLOBAL,
    Dictionary;

    public static String toString(ExceptionLevel level) {
        switch (level) {
            case GLOBAL:
                return "GLOBAL";
            case Dictionary:
                return "Dictionary";
            default:
                return "WTF";
        }
    }
}
