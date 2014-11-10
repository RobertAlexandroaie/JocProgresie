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
    private StringBuilder win;
    public int ratio;

    /**
     * Contructor
     */
    public Player() {
        word = new StringBuilder();
        win = new StringBuilder();
        hand = new int[26];
        for (int i = 0; i < 26; i++)
            hand[i] = 0;
        ratio = 0;
    }

    /**
     * 
     * @param card
     *            the card added in user's hand
     */
    public void addLetter(char card) {
        hand[card - 'A']++;
        word.append(card);
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
     * @param poz
     *            indicele primei litere din progresie, daca exista
     * @param lenCuvant
     *            lungimea progresiei
     * @return
     */
    public boolean isProgression(int poz, int lenCuvant) {
        int i;
        int c;
        ratio = 1;
        boolean ret = true;
        int[] viz = new int[26];

        for (ratio = 1; ratio <= 25; ratio++) {
            ret = true;
            win = new StringBuilder();
            win.append((char) (poz + 'A'));
            initVisited(viz);
            viz[poz] = 1;

            for (i = (poz + ratio) % 26, c = 1; c < lenCuvant && i != poz; c++, i = (i + ratio) % 26) {
                if (hand[i] == 0 && viz[i] >= hand[i]) {
                    ret = false;
                    break;
                } else {
                    viz[i]++;
                    win.append((char) (i + 'A'));
                }
            }

            if (ret == true && c == lenCuvant)
                return ret;
        }
        return ret;
    }

    /**
     * Verifica daca jucatorul curent este castigator
     * 
     * @param lenCuvant
     *            lungimea progresiei
     * @return
     */
    public boolean Castigator(int lenCuvant) {
        int i;
        for (i = 0; i < word.length(); i++) {
            if (isProgression(word.charAt(i) - 'A', lenCuvant) == true)
                return true;
        }
        win.delete(0, win.length());
        return false;
    }

    /**
     * 
     * @return cuvantul format pana in momentul apelului
     */
    public StringBuilder getCuvant() {
        return word;
    }

    /**
     * Apelata numai daca e castigator
     * 
     * @return cuvantul cu care a castigat
     */
    public StringBuilder getWin() {
        return win;
    }
}
