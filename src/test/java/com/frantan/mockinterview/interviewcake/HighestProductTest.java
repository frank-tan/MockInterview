package com.frantan.mockinterview.interviewcake;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by tan on 2/05/2016.
 */
public class HighestProductTest {

    @Test
    public void TestGetHighestProductOfThreeInt() throws Exception {
        assertEquals(24, HighestProduct.getHighestProductOfThreeInt(new int[]{1, 2, 3, 4}));
        assertEquals(80, HighestProduct.getHighestProductOfThreeInt(new int[]{10, -2, 3, -4}));
    }
}
