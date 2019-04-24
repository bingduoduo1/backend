package model.dictionary.model;

import org.junit.Before;
import org.junit.Test;

import model.dictionary.exception.DictionaryException;
import model.dictionary.exception.NotMatchActionTypeExpection;

import static model.dictionary.model.ActionType.COMMAND;
import static model.dictionary.model.ActionType.INPUT;
import static model.dictionary.model.ExecutePlaceType.SHELL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandActionTest {
    CommandAction mAction;
    @Test
    public void testExecutePlaceType() {
        try {
            mAction = new CommandAction(ActionType.COMMAND, SHELL, "backspace");
            assertEquals(SHELL, mAction.getExecutePlace());
        } catch (DictionaryException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testContent() {
        try {
            mAction = new CommandAction(ActionType.COMMAND, SHELL, "backspace");
            assertEquals("backspace", mAction.getContent());
        } catch (DictionaryException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConstructor() {
        try {
            mAction = new CommandAction(INPUT, SHELL, "backspace");
        }catch (DictionaryException e) {
            assertTrue(e instanceof NotMatchActionTypeExpection);
        }
        try {
            mAction = new CommandAction(COMMAND, SHELL, "xxx");
        } catch (DictionaryException e) {
            assertTrue(e instanceof DictionaryException);
        }
    }
}
