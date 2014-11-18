/**
 * 
 */
package com.fii.homework.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ralexandroaie
 *
 */
public class PlayerTest {
    private Player playerUnderTest;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        playerUnderTest = new Player();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link com.fii.homework.model.Player#addLetter(char)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddLetterWithNumber() {
        playerUnderTest.addLetter('2');
    }
    
    /**
     * Test method for {@link com.fii.homework.model.Player#addLetter(char)}.
     */
    @Test
    public void testAddLetterWithLowerCase() {
        playerUnderTest.addLetter('a');
        assertTrue(playerUnderTest.getWord().endsWith("A"));
    }


    /**
     * Test method for {@link com.fii.homework.model.Player#addLetter(char)}.
     */
    @Test
    public void testAddLetterCorrectArg() {
        playerUnderTest.addLetter('A');
        assertTrue(playerUnderTest.getWord().endsWith("A"));
    }

    /**
     * Test method for {@link com.fii.homework.model.Player#isWinner(int)}.
     */
    @Test
    public void testIsWinnerWithNoWinningWord() {
        playerUnderTest.addLetter('a');
        playerUnderTest.addLetter('b');
        playerUnderTest.addLetter('d');
        assertFalse(playerUnderTest.isWinner(3));
    }
    

    /**
     * Test method for {@link com.fii.homework.model.Player#isWinner(int)}.
     */
    @Test
    public void testIsWinnerWithWordExpectedBiggerThanCurrentWord() {
        playerUnderTest.addLetter('a');
        playerUnderTest.addLetter('b');
        playerUnderTest.addLetter('c');
        assertFalse(playerUnderTest.isWinner(4));
    }

    

    /**
     * Test method for {@link com.fii.homework.model.Player#isWinner(int)}.
     */
    @Test
    public void testIsWinnerWithWinningWord() {
        playerUnderTest.addLetter('a');
        playerUnderTest.addLetter('b');
        playerUnderTest.addLetter('c');
        assertTrue(playerUnderTest.isWinner(3));
    }


    /**
     * Test method for {@link com.fii.homework.model.Player#getWord()}.
     */
    @Test
    public void testGetWord() {
        playerUnderTest.addLetter('a');
        playerUnderTest.addLetter('b');
        playerUnderTest.addLetter('c');
        assertTrue(playerUnderTest.getWord().equals("ABC"));
    }

    /**
     * Test method for {@link com.fii.homework.model.Player#getWinningWord()}.
     */
    @Test
    public void testGetWinningWordWithCorrectWord() {
        playerUnderTest.addLetter('a');
        playerUnderTest.addLetter('b');
        playerUnderTest.addLetter('c');
        assertTrue(playerUnderTest.isWinner(3));
        assertTrue(playerUnderTest.getWinningWord().equals("ABC"));
    }
    
    /**
     * Test method for {@link com.fii.homework.model.Player#getWinningWord()}.
     */
    @Test
    public void testGetWinningWordWithoutCheck() {
        playerUnderTest.addLetter('a');
        playerUnderTest.addLetter('y');
        playerUnderTest.addLetter('x');
        assertFalse(playerUnderTest.getWinningWord().equals("YX"));
    }
    
    /**
     * Test method for {@link com.fii.homework.model.Player#getWinningWord()}.
     */
    @Test
    public void testGetWinningWordWithCorrectWordAndMoreLetters() {
        playerUnderTest.addLetter('a');
        playerUnderTest.addLetter('x');
        playerUnderTest.addLetter('y');
        playerUnderTest.addLetter('z');
        assertTrue(playerUnderTest.isWinner(3));
        assertTrue(playerUnderTest.getWinningWord().equals("XYZ"));
    }
    
    /**
     * Test method for {@link com.fii.homework.model.Player#getWinningWord()}.
     */
    @Test
    public void testGetWinningWordWithCorrectWordAndMoreCorrectWords() {
        playerUnderTest.addLetter('a');
        playerUnderTest.addLetter('b');
        playerUnderTest.addLetter('c');
        playerUnderTest.addLetter('x');
        playerUnderTest.addLetter('e');
        playerUnderTest.addLetter('f');
        playerUnderTest.addLetter('g');
        assertTrue(playerUnderTest.isWinner(3));
        assertTrue(playerUnderTest.getWinningWord().equals("ABC"));
    }

    /**
     * Test method for {@link com.fii.homework.model.Player#getWinningWord()}.
     */
    @Test
    public void testGetWinningWordWithCorrectWordAndBigRatio() {
        playerUnderTest.addLetter('z');
        playerUnderTest.addLetter('y');
        playerUnderTest.addLetter('x');
        assertTrue(playerUnderTest.isWinner(3));
        assertTrue(playerUnderTest.getWinningWord().equals("ZYX"));
    }

    /**
     * Test method for {@link com.fii.homework.model.Player#getWinningWord()}.
     */
    @Test
    public void testGetWinningWordWithIncorrectWord() {
        playerUnderTest.addLetter('a');
        playerUnderTest.addLetter('b');
        playerUnderTest.addLetter('d');
        assertFalse(playerUnderTest.isWinner(3));
        assertTrue(playerUnderTest.getWinningWord().equals(""));
    }
}
