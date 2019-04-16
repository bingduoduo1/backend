package model.dictionary.helper;

import java.util.ArrayList;

public abstract class InputActionHelper extends GlobalHelper{

    private static ArrayList<String> mTokenList = new ArrayList<String>() {{
        add("(");
        add(")");
        add("a");
        add("b");
        add("c");
        add("d");
        add("e");
        add("f");
        add("g");
        add("h");
        add("i");
        add("j");
        add("l");
        add("m");
        add("n");
        add("o");
        add("p");
        add("q");
        add("r");
        add("s");
        add("t");
        add("u");
        add("v");
        add("w");
        add("x");
        add("y");
        add("z");
    }};

    private static ArrayList<String> mShellKeyWordList = new ArrayList<String>() {{
        add("ls");
        add("cd");
        add("python");
        add(" ");
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
