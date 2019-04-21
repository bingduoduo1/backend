package model.dictionary.helper;

import java.util.ArrayList;

public abstract class InputActionHelper extends GlobalHelper{

    private static ArrayList<String> mTokenList = new ArrayList<String>() {{
        add("(");
        add(")");
        add(":");
        add(".");
        add("-");
        add("_");
        add(" ");
        add("\n");
        add("\r\n");
    }};

    private static ArrayList<String> mShellKeyWordList = new ArrayList<String>() {{
        add("ls");
        add("cd");
        add("python");
        add("pwd");
        add("cp");
        add("rm");
        add("chmod");
        add("bash");
    }};

    private static ArrayList<String> mPythonKeyWordList = new ArrayList<String>() {{
        add("import");
        add("from");
        add("def");
        add("with");
        add("as");
        add("if");
        add("elif");
        add("while");
        add("and");
        add("not");
        add("for");
        add("in");
        add("is");
        add("math");
        add("sin");
        add("cos");
        add("exit");
        add("numpy");
    }};

    private static ArrayList<String> mCombinedActionList = new ArrayList<String>() {{
        add("welcome to use BDD!!!");
    }};


    public static boolean inputActionContentCheck(String content) {
        return (isAlpha(content) ||
                isInteger(content) ||
                mTokenList.contains(content) ||
                mShellKeyWordList.contains(content) ||
                mPythonKeyWordList.contains(content) ||
                mCombinedActionList.contains(content));
    }
}
