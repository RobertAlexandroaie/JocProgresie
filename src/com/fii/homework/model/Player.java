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
    /**
     * 
     */
    private static final int MAX_CARDS = 26;
    /**
     * 
     */
    private static final int MAX_RATIO = 25;
    /**
     * 
     */
    private static final int MIN_RATIO = 1;
    private int[] hand;
    private StringBuilder word;
    private StringBuilder winningWord;
    public int ratio;

    /**
     * 
     */
    public Player() {
        ratio = 0;
        word = new StringBuilder();
        winningWord = new StringBuilder();
        buildHand();
    }

    /**
     * 
     */
    private void buildHand() {
        hand = new int[MAX_CARDS];
        for (int i = 0; i < MAX_CARDS; i++)
            hand[i] = 0;
    }

    /**
     * 
     * @param letter
     *            the card added in user's hand
     */
    public void addLetter(char letter) {
        markLetter(letter);
        word.append(letter);
    }

    /**
     * @param letter
     */
    private void markLetter(char letter) {
        hand[letter - 'A']++;
    }

    /**
     * 
     * @param visited
     * 
     */
    private void initVisited(int[] visited) {
        for (int i = 0; i < MAX_CARDS; i++)
            visited[i] = 0;
    }

    /**
     * 
     * @param startLetter
     *            indicele primei litere din progresie, daca exista
     * @param wordLength
     *            lungimea progresiei
     * @return
     */
    public boolean isProgression(int startLetter, int wordLength) {
        ratio = 1;
        boolean isProgression = true;
        int[] visited = new int[MAX_CARDS];

        for (ratio = MIN_RATIO; ratio <= MAX_RATIO; ratio++) {
            isProgression = true;
            winningWord = new StringBuilder();
            winningWord.append((char) (startLetter + 'A'));
            initVisited(visited);
            visited[startLetter] = 1;
            int i, letterPosition;
            for (i = (startLetter + ratio) % MAX_CARDS, letterPosition = 1; letterPosition < wordLength
                    && i != startLetter; letterPosition++, i = (i + ratio)
                    % MAX_CARDS) {
                if (hand[i] == 0 && visited[i] >= hand[i]) {
                    isProgression = false;
                    break;
                } else {
                    visited[i]++;
                    winningWord.append((char) (i + 'A'));
                }
                if (isProgression == true && letterPosition == wordLength)
                    return isProgression;
            }
        }
        return isProgression;
    }

    /**
     * Verifica daca jucatorul curent este castigator
     * 
     * @param wordLength
     *            lungimea progresiei
     * @return
     */
    public boolean isWinner(int wordLength) {
        for (int i = 0; i < word.length(); i++) {
            if (isProgression(word.charAt(i) - 'A', wordLength))
                return true;
        }
        winningWord.delete(0, winningWord.length());
        return false;
    }

    /**
     * 
     * @return cuvantul format pana in momentul apelului
     */
    public StringBuilder getWord() {
        return word;
    }

    /**
     * Apelata numai daca e castigator
     * 
     * @return cuvantul cu care a castigat
     */
    public StringBuilder getWinningWord() {
        return winningWord;
    }
}
