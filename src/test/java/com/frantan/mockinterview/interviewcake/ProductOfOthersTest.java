package com.frantan.mockinterview.interviewcake;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

/**
 * Created by tan on 1/05/2016.
 */
public class ProductOfOthersTest {
    @Test
    public void testGetProductsOfAllIntsExceptAtIndex() throws Exception {
        assertTrue(
                Arrays.equals(
                        new int[]{84, 12, 28, 21},
                        ProductOfOthers.getProductsOfAllIntsExceptAtIndex(new int[]{1,7,3,4})));
    }
}
