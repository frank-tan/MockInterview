package com.franktan.mockinterview.udacity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tan on 15/03/2016.
 */
public class StringCompressorTest {
    @Test
    public void testCompress() throws Exception {
        assertEquals(null, StringCompressor.compress(null));
        assertEquals("", StringCompressor.compress(""));
        assertTrue(StringCompressor.compress("abc").equals("abc"));
        assertTrue(StringCompressor.compress("aabbcc").equals("aabbcc"));
        assertTrue("actual:"+StringCompressor.compress("aaabbcc"),StringCompressor.compress("aaabbcc").equals("a3b2c2"));
        assertTrue("actual:"+StringCompressor.compress("aaabbbc"),StringCompressor.compress("aaabbbc").equals("a3b3c1"));
        assertTrue("actual:"+StringCompressor.compress("aaabbbaac"),StringCompressor.compress("aaabbbaac").equals("a3b3a2c1"));
        assertTrue("actual:"+StringCompressor.compress("aabcccccaaa"),StringCompressor.compress("aabcccccaaa").equals("a2b1c5a3"));
    }

    @Test
    public void testNumOfUniqueChar() throws Exception {
        assertEquals(0, StringCompressor.numOfUniqueChar(null));
        assertEquals(0, StringCompressor.numOfUniqueChar(""));
        assertEquals(1, StringCompressor.numOfUniqueChar("aaa"));
        assertEquals(3, StringCompressor.numOfUniqueChar("aaabccc"));
        assertEquals(5, StringCompressor.numOfUniqueChar("aabcccaaa1d1"));
    }
}