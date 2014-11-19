/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fii.homework.main;

import java.util.Scanner;

/**
 *
 * @author Robert
 */
public class Main {

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        String playersCountS = args.length > 0 ? args[0] : "";
        String wordLengthS = args.length > 1 ? args[1] : "";

        int playersCount = 2, wordLength = 1;

        Scanner scanner = new Scanner(System.in);
        playersCount = returnNumberInputForLabel(playersCountS,
                "numarul de jucatori", scanner);
        wordLength = returnNumberInputForLabel(wordLengthS,
                "lungimea cuvantului", scanner);
        scanner.close();
        scanner = null;
        Game game = new Game(playersCount, wordLength);
        game.startGame();
    }

    /**
     * @param playersCountS
     */
    private static int returnNumberInputForLabel(String value, String label,
            Scanner scan) {
        String input = value;
        int intValue = 0;
        boolean test = true;
        while (test) {
            try {
                intValue = Integer.parseInt(input);
                test = false;
            } catch (NumberFormatException e) {
                System.out
                        .println("Va rugam introduceti un numar natural pentru "
                                + label + ":");
                if (scan.hasNextLine()) {
                    input = scan.nextLine();
                } else {
                    test = false;
                }
            }
        }
        return intValue;
    }
}
