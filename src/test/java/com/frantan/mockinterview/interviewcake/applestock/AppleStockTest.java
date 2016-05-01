package com.frantan.mockinterview.interviewcake.applestock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tan on 1/05/2016.
 */
public class AppleStockTest {
    @Test
    public void TestGetMaxProfit() throws Exception {
        assertEquals(6, AppleStock.getMaxProfit(new int[]{10, 7, 5, 8, 11, 9}));
    }
}
