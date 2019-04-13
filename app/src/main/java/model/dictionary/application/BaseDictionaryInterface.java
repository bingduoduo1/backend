package model.dictionary.application;



import model.dictionary.exception.DictionaryException;
import model.dictionary.model.BaseAction;
import model.dictionary.model.BaseWord;
import model.dictionary.model.CustomWord;
import model.dictionary.model.NatureLanguageType;

interface BaseDictionaryInterface {
    void initDictionary();
    void initDictionary(final String config_path) throws DictionaryException;
    BaseAction lookUpAction(BaseWord key);
    default BaseAction lookUpAction(String word) {
        NatureLanguageType languageType = NatureLanguageType.ENGLISH;
        BaseWord key = new CustomWord(word, languageType);
        return lookUpAction(key);
    }
}
