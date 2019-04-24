package com.termux.app;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExtraKeysViewTest extends TestCase {

    @Test
    public void testmaximumLength() {
        String[][] matrix= {{"dkjf","ndj","s"},{"fd","ed","as"},{"cudi","asdg","fsgdf"}};
        assertEquals(3,ExtraKeysView.maximumLength(matrix));
    }

}
