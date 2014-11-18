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
                winningWord = word.substring(0, 2);
                hasProgression = true;
                return hasProgression;
            } else {
                ratio = (word.charAt(lastLetterIndex)
                        - word.charAt(lastLetterIndex - 1) + 26) % 26;
                int nextRatio;
                int winningWordLength = 2;
                int startLetterIndex = lastLetterIndex - 1;
                while (winningWordLength < requiredWordLength
                        && lastLetterIndex < word.length()-1) {
                    lastLetterIndex++;
                    hasProgression = true;
                    nextRatio = (word.charAt(lastLetterIndex)
                            - word.charAt(lastLetterIndex - 1) + 26) % 26;
                    if (nextRatio != ratio) {
                        ratio = nextRatio;
                        startLetterIndex = lastLetterIndex - 1;
                        hasProgression = false;
                        winningWordLength = 2;
                    } else {
                        winningWordLength = lastLetterIndex - startLetterIndex
                                + 1;
                    }
                }
                if (hasProgression) {
                    winningWord = word.substring(lastLetterIndex
                            - requiredWordLength + 1, lastLetterIndex + 1);
                } else {
                    hasProgression = false;
                    return hasProgression;
                }
            }
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
    public String getWord() {
        return word.toString();
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
