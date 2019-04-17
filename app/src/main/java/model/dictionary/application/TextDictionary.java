package model.dictionary.application;

import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.security.auth.login.LoginException;

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

public class TextDictionary implements BaseDictionaryInterface {
    private HashMap<BaseWord, BaseAction> mDictionary;
    private static TextDictionary mDictReference = new TextDictionary();

    private TextDictionary() {
        mDictionary = new HashMap<BaseWord, BaseAction>();
        initDictionary();
    }
    public static TextDictionary createDictionary() {
        return mDictReference;
    }
    @Override
    public void initDictionary() {
        try {
            mDictionary.put(new CustomWord("a", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "a"));
            mDictionary.put(new CustomWord("bracket", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "("));
            mDictionary.put(new CustomWord("b", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "b"));
            mDictionary.put(new CustomWord("c", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "c"));
            mDictionary.put(new CustomWord("abccc", NatureLanguageType.ENGLISH),
                new InputAction(ActionType.INPUT, ExecutePlaceType.SHELL, "b"));
        } catch (DictionaryException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initDictionary(String config_path) throws DictionaryException{
        throw new NotImplementedError();
    }

    public BaseAction lookUpAction(BaseWord key) {
        Log.e(TAG, "in text !!!!lookUpAction: search for key: " + key.getRawData()+";" );
        Log.e(TAG,key.getNatureType().toString());
        CustomWord new_key = new CustomWord("b", NatureLanguageType.ENGLISH);
        Log.e(TAG, mDictionary.containsKey(new_key)?"True":"false");
        Log.e(TAG,mDictionary.keySet().toString());

        for (Map.Entry<BaseWord, BaseAction> entry : mDictionary.entrySet()) {
            //entry.getKey();
            //entry.getValue();
            Log.e(TAG, "Key:"+entry.getKey().getRawData() + " Value:" + entry.getValue().getActionType() );
        }


        if (mDictionary.containsKey((CustomWord)key)) {
            Log.e(TAG, "text lookUpAction: search for key: " + key.getRawData() );
            return mDictionary.get(key);
        } else {
            return null;
        }
    }
}
