/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fii.homework.model;

/**
 *
 * @author Robert
 */
public class Player {

    private Word word;

    /**
     * 
     */
    public Player() {
        word = new Word();
    }

    /**
     * 
     * @param letter
     *            the card added in user's hand
     */
    public void addLetter(char letter) throws IllegalArgumentException {
        word.addLetter(letter);
    }

    /**
     * Verifica daca jucatorul curent este castigator
     * 
     * @param requiredWordLength
     *            lungimea progresiei
     * @return
     */
    public boolean isWinner(int requiredWordLength) {
        return word.hasProgression(requiredWordLength);
    }

    /**
     * 
     * @return cuvantul format pana in momentul apelului
     */
    public String getWord() {
        return word.getWord();
    }

    /**
     * Apelata numai daca e castigator
     * 
     * @return cuvantul cu care a castigat
     */
    public String getWinningWord() {
        return word.getWinningWord();
    }

    public int ratio() throws IllegalAccessException{
        return word.ratio();
    }
}
