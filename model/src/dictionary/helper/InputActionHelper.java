package dictionary.helper;

import java.util.ArrayList;

public abstract class InputActionHelper {

    private static ArrayList<String> mTokenList = new ArrayList<>() {{
        add("(");
        add(")");
    }};

    private static ArrayList<String> mShellKeyWordList = new ArrayList<>() {{
        add("ls");
        add("cd");
        add("python");
    }};
    private static ArrayList<String> mPythonKeyWordList = new ArrayList<>() {{
        add("import");
        add("math");
        add("sin");
        add("cos");
        add("exit");
    }};

    private static boolean isAlpha(String content) {
        if (content.length() != 1) {
            return false;
        }
        char value = content.charAt(0);
        return (value >= 'a' && value <= 'z') || (value >= 'A' && value <= 'Z');
    }

    private static boolean isInteger(String content) {
        try {
            Integer.parseInt(content);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean inputActionContentCheck(String content) {
        return (isAlpha(content) ||
                isInteger(content) ||
                mTokenList.contains(content) ||
                mShellKeyWordList.contains(content) ||
                mPythonKeyWordList.contains(content));
    }
}
