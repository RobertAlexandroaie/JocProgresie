/**
 * 
 */
package com.fii.homework.model;

import java.util.Scanner;

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
    private char buildRandomCard() {
        char card;
        double randomNumber;

        randomNumber = Math.random();
        card = (char) (65 + (char) (randomNumber * 26));

        return card;
    }

    public void buildPlayerNumber(String value) throws NumberFormatException {
        setPlayerNr(Integer.parseInt(value));
    }

    /**
     * Atribuie jocului lungimea progresiei
     * 
     * @param value
     *            sirul atribuit ca valoare
     */
    private void buildWordLength(String value) {
      
        wordLength = Integer.parseInt(arg.toString());
    }

    public void startGame() {
        int round = 1;
        boolean gameover = false;

        while (true) {
            System.out.println("Runda " + round);
            for (int i = 0; i < playersCount; i++) {
                char randomCard = buildRandomCard();
                players[i].addLetter(randomCard);
                System.out.println("Jucatorul " + (i + 1)
                        + " a primit cartea: " + randomCard + ": "
                        + players[i].getCuvant());
            }

            for (int i = 0; i < joc.n; i++) {
                if (players[i].Castigator(joc.p)) {
                    System.out.println("Jucatorul " + (i + 1) + " a castigat: "
                            + players[i].getWin());
                    System.out.println("Ratia: " + players[i].ratio);
                    gameover = true;
                    break;
                }
            }
            if (gameover)
                break;
            round++;
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
