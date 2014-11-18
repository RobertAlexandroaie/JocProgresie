/**
 * 
 */
package com.fii.homework.model;

/**
 * @author ralexandroaie
 *
 */
public class Word {

    private StringBuilder word;
    private String winningWord;
    private int ratio;
    private int lastLetterIndex;
    private boolean hasProgression;

    public Word() {
        ratio = 0;
        lastLetterIndex = 1;
        word = new StringBuilder();
        winningWord = "";
    }

    /**
     * 
     * @param letter
     *            the card added in user's hand
     */
    void addLetter(char letter) throws IllegalArgumentException {
        if (Character.isAlphabetic(letter)) {
            word.append(Character.toUpperCase(letter));
        } else {
            throw new IllegalArgumentException();
        }
    }

    boolean hasProgression(int requiredWordLength) {
        if (requiredWordLength <= word.length()) {
            if (requiredWordLength == 2) {
                winningWord = word.toString();
                hasProgression = true;
                return hasProgression;
            }
            int startLetterIndex = lastLetterIndex - 1;
            ratio = (word.charAt(lastLetterIndex) - word.charAt(startLetterIndex) + 26) % 26;
            int nextRatio;
            while (lastLetterIndex++ - startLetterIndex + 1 < requiredWordLength) {
                nextRatio = (word.charAt(lastLetterIndex)
                        - word.charAt(lastLetterIndex - 1) + 26) % 26;
                if (nextRatio != ratio) {
                    hasProgression = false;
                    return hasProgression;
                }
            }
            winningWord = word.substring(startLetterIndex, lastLetterIndex);
        } else {
            hasProgression = false;
            return hasProgression;
        }
        hasProgression = true;
        return hasProgression;
    }

    /**
     * @return the word
     */
    public StringBuilder getWord() {
        return word;
    }

    /**
     * @return the winningWord
     */
    public String getWinningWord() {
        if (hasProgression) {
            return winningWord;
        } else {
            return "";
        }
    }

    /**
     * @return the ratio
     */
    public int getRatio() {
        return ratio;
    }
}
