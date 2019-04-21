package model.dictionary.application;

import java.util.HashMap;

import model.dictionary.exception.DictionaryException;
import model.dictionary.exception.NotImplementedError;
import model.dictionary.model.ActionType;
import model.dictionary.model.BaseAction;
import model.dictionary.model.BaseWord;
import model.dictionary.model.ExecutePlaceType;
import model.dictionary.model.InputAction;
import model.dictionary.model.CustomWord;
import model.dictionary.model.NatureLanguageType;

public class PythonDictionary implements BaseDictionaryInterface {
    private HashMap<BaseWord, BaseAction> mDictionary;
    private static PythonDictionary mDictReference = new PythonDictionary();
    private PythonDictionary() {
        mDictionary = new HashMap<BaseWord, BaseAction>();
        initDictionary();
    }
    public static PythonDictionary createDictionary() {
        return mDictReference;
    }
    @Override
    public void initDictionary() {
        try {
            mDictionary.put(new CustomWord("import", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "import"));
            mDictionary.put(new CustomWord("math", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "math"));
            mDictionary.put(new CustomWord("sin", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "sin"));
            mDictionary.put(new CustomWord("cos", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "cos"));
            mDictionary.put(new CustomWord("exit", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "exit"));
            mDictionary.put(new CustomWord("from", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "from"));
            mDictionary.put(new CustomWord("define", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "def"));
            mDictionary.put(new CustomWord("with", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "with"));
            mDictionary.put(new CustomWord("as", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "as"));
            mDictionary.put(new CustomWord("if", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "if"));
            mDictionary.put(new CustomWord("else if", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "elif"));
            mDictionary.put(new CustomWord("and", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "and"));
            mDictionary.put(new CustomWord("与", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "and"));
            mDictionary.put(new CustomWord("or", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "or"));
            mDictionary.put(new CustomWord("或", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "or"));
            mDictionary.put(new CustomWord("not", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "not"));
            mDictionary.put(new CustomWord("for", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "for"));
            mDictionary.put(new CustomWord("in", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "in"));
            mDictionary.put(new CustomWord("is", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "is"));
            mDictionary.put(new CustomWord("numpy", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.GENERAL, "numpy"));


        } catch (DictionaryException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initDictionary(String config_path) throws DictionaryException{
        throw new NotImplementedError();
    }

    public BaseAction lookUpAction(BaseWord key) {
        if (mDictionary.containsKey(key)) {
            return mDictionary.get(key);
        } else {
            return null;
        }
    }
}
