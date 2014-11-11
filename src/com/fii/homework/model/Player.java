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
    private int[] hand;
    private StringBuilder word;
    private StringBuilder winningWord;
    public int ratio;

    /**
     * 
     */
    public Player() {
        word = new StringBuilder();
        winningWord = new StringBuilder();
        hand = new int[26];
        for (int i = 0; i < 26; i++)
            hand[i] = 0;
        ratio = 0;
    }

    /**
     * 
     * @param letter
     *            the card added in user's hand
     */
    public void addLetter(char letter) {
        hand[letter - 'A']++;
        word.append(letter);
    }

    /**
     * 
     * @param visited
     * 
     */
    private void initVisited(int[] visited) {
        for (int i = 0; i < 26; i++)
            visited[i] = 0;
    }

    /**
     * 
     * @param position
     *            indicele primei litere din progresie, daca exista
     * @param wordLength
     *            lungimea progresiei
     * @return
     */
    public boolean isProgression(int position, int wordLength) {
        int i;
        int letter;
        ratio = 1;
        boolean isProgression = true;
        int[] visited = new int[26];

        for (ratio = 1; ratio <= 25; ratio++) {
            isProgression = true;
            winningWord = new StringBuilder();
            winningWord.append((char) (position + 'A'));
            initVisited(visited);
            visited[position] = 1;

            for (i = (position + ratio) % 26, letter = 1; letter < wordLength
                    && i != position; letter++, i = (i + ratio) % 26) {
                if (hand[i] == 0 && visited[i] >= hand[i]) {
                    isProgression = false;
                    break;
                } else {
                    visited[i]++;
                    winningWord.append((char) (i + 'A'));
                }
            }

            if (isProgression == true && letter == wordLength)
                return isProgression;
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
