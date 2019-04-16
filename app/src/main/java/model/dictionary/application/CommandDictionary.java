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

public class CommandDictionary implements BaseDictionaryInterface {
    private HashMap<BaseWord, BaseAction> mDictionary;
    private static CommandDictionary mDictReference = new CommandDictionary();
    private CommandDictionary() {
        mDictionary = new HashMap<BaseWord, BaseAction>();
        initDictionary();
    }

    public static CommandDictionary createDictionary() {
        return mDictReference;
    }
    @Override
    public void initDictionary() {
        try {
            mDictionary.put(new CustomWord("ls", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "ls"));
            mDictionary.put(new CustomWord("cd", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "cd"));
            mDictionary.put(new CustomWord(" ", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, " "));
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
