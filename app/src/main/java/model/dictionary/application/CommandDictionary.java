package model.dictionary.application;


import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import model.dictionary.exception.DictionaryException;
import model.dictionary.exception.NotImplementedError;
import model.dictionary.model.ActionType;
import model.dictionary.model.BaseAction;
import model.dictionary.model.BaseWord;
import model.dictionary.model.ExecutePlaceType;
import model.dictionary.model.InputAction;
import model.dictionary.model.CustomWord;
import model.dictionary.model.NatureLanguageType;

import static android.content.ContentValues.TAG;

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

            mDictionary.put(new CustomWord("python", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "python"));

            // 中文指令字
            mDictionary.put(new CustomWord("回车", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "\r\n"));
            mDictionary.put(new CustomWord("换行", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "\n"));
            mDictionary.put(new CustomWord("空格", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, " "));
            mDictionary.put(new CustomWord("删除", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "DEL"));
            //python
            mDictionary.put(new CustomWord("派送", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "python"));
            mDictionary.put(new CustomWord("拍手", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "python"));
            mDictionary.put(new CustomWord("胎生", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "python"));
            mDictionary.put(new CustomWord("pass on", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "python"));
            mDictionary.put(new CustomWord("拍摄", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "python"));
            mDictionary.put(new CustomWord("潘松", NatureLanguageType.CHINESE),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "python"));

        } catch (DictionaryException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initDictionary(String config_path) throws DictionaryException{
        throw new NotImplementedError();
    }

    public BaseAction lookUpAction(BaseWord key) {
        for (Map.Entry<BaseWord, BaseAction> entry : mDictionary.entrySet()) {
            Log.e(TAG, "Key:"+entry.getKey().getRawData() + " Value:" + entry.getValue().getActionType() );
        }

        if (mDictionary.containsKey(key)) {
            Log.d(TAG, "lookUpAction: " + key.getRawData() + "::" + key.getNatureType());
            return mDictionary.get(key);
        } else {
            return null;
        }
    }
}
