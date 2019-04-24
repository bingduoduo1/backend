package model.dictionary.helper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandActionHelperTest {
    @Test
    public void testCommandActionContentCheck(){
        boolean ret =  CommandActionHelper.commandActionContentCheck("backspace");
        assertTrue(ret);
        ret = CommandActionHelper.commandActionContentCheck("xxx");
        assertFalse(ret);
    }
}
