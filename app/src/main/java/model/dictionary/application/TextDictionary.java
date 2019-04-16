package model.dictionary.application;

import android.util.Log;

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
            //Log.e(TAG, "lookUpAction: search for key: " + key.getRawData() );
            return mDictionary.get(key);
        } else {
            return null;
        }
    }
}
