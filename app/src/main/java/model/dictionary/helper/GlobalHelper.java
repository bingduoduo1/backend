package model.dictionary.helper;

public abstract class GlobalHelper {
    public static boolean isAlpha(String content) {
        if (content.length() != 1) {
            return false;
        }
        char value = content.charAt(0);
        return (value >= 'a' && value <= 'z') || (value >= 'A' && value <= 'Z');
    }

    public static boolean isInteger(String content) {
        try {
            Integer.parseInt(content);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //TODO 中英文识别
}
