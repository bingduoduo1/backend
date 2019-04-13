package model.dictionary.helper;

import java.util.ArrayList;

public abstract class InputActionHelper extends GlobalHelper{

    private static ArrayList<String> mTokenList = new ArrayList<String>() {{
        add("(");
        add(")");
    }};

    private static ArrayList<String> mShellKeyWordList = new ArrayList<String>() {{
        add("ls");
        add("cd");
        add("python");
    }};
    private static ArrayList<String> mPythonKeyWordList = new ArrayList<String>() {{
        add("import");
        add("math");
        add("sin");
        add("cos");
        add("exit");
    }};


    public static boolean inputActionContentCheck(String content) {
        return (isAlpha(content) ||
                isInteger(content) ||
                mTokenList.contains(content) ||
                mShellKeyWordList.contains(content) ||
                mPythonKeyWordList.contains(content));
    }
}
