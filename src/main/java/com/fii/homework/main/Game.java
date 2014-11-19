/**
 * 
 */
package com.fii.homework.main;

import com.fii.homework.model.Player;

/**
 * @author ralexandroaie
 *
 */
public class Game {
    private int playersCount;
    private int wordLength;
    Player[] players;

    /**
     * 
     */
    public Game() {
        playersCount = 2;
        wordLength = 0;
        buildPlayers();
    }

    public Game(int playersCount, int wordLength) throws NumberFormatException {
        setPlayersCount(playersCount);
        setWordLength(wordLength);
        buildPlayers();
    }

    /**
     * 
     */
    private void buildPlayers() {
        players = new Player[playersCount];
        for (int i = 0; i < playersCount; i++) {
            players[i] = new Player();
        }
    }

    /**
     * 
     * @return random char from A to Z
     */
    private char buildRandomLetter() {
        char letter;
        double randomNumber;

        randomNumber = Math.random();
        letter = (char) (65 + (char) (randomNumber * 26));

        return letter;
    }

    public void startGame() {
        int round = 1;
        boolean gameover = false;

        while (!gameover) {
            System.out.println("Runda " + round++);
            for (int i = 0; i < playersCount && !gameover; i++) {
                char randomLetter = buildRandomLetter();
                players[i].addLetter(randomLetter);
                System.out.println("Jucatorul " + (i + 1)
                        + " a primit cartea: " + randomLetter + ": "
                        + players[i].getWord());

                if (players[i].isWinner(wordLength)) {
                    System.out
                            .println("==================== GAME OVER ========================");
                    System.out.println("Jucatorul " + (i + 1)
                            + " a castigat. Cuvantul format: "
                            + players[i].getWinningWord());
                    try {
                        System.out.println("Ratia: " + players[i].ratio());
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    gameover = true;
                }
            }

        }
    }

    /**
     * @return the playersCount
     */
    public int getPlayersCount() {
        return playersCount;
    }

    /**
     * @param playersCount
     *            the playersCount to set
     */
    private void setPlayersCount(int playersCount) {
        if (playersCount > 2) {
            this.playersCount = playersCount;
        }
    }

    /**
     * @return the wordLength
     */
    public int getWordLength() {
        return wordLength;
    }

    /**
     * @param wordLength
     *            the wordLength to set
     */
    private void setWordLength(int wordLength) {
        if (wordLength > 0) {
            this.wordLength = wordLength;
        }
    }

    /**
     * @return the players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * @param players
     *            the players to set
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

}
