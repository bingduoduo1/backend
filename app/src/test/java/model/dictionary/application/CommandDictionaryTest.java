package model.dictionary.application;

import android.drm.DrmStore;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import model.dictionary.model.BaseAction;
import model.dictionary.model.BaseWord;
import model.dictionary.model.CustomWord;
import model.dictionary.model.NatureLanguageType;

import static org.junit.Assert.*;

public class CommandDictionaryTest {

    private HashMap<BaseWord, BaseAction> mDictionary;
    CommandDictionary commanddictionary;
   // @Before
   // public void testcommandDictionary() {
   //     mDictionary = new HashMap<BaseWord, BaseAction>();
   //     commanddictionary.initDictionary();
  //  }

    @Test
   /* public void testDictionary(){
        CommandDictionary cmdDictionary = CommandDictionary.createDictionary();
        cmdDictionary.lookUpAction(new CustomWord("ls", NatureLanguageType.ENGLISH));
    }*/

    public void testlookUpAction() {
        CommandDictionary cmdDictionary = CommandDictionary.createDictionary();
        BaseWord base = new CustomWord("ls", NatureLanguageType.ENGLISH);
        //assertEquals("ls", (cmdDictionary.lookUpAction(base));
    }
}
