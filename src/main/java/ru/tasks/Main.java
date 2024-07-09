package ru.tasks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProbabilityCalculator probabilityCalculator = new ProbabilityCalculator(1_000_000);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sequence of first player: ");
        int[] firstPlayerSequence = new int[3];
        for (int i = 0; i < 3; i++) {
            firstPlayerSequence[i] = scanner.nextInt();
        }

        System.out.print("Enter sequence of second player: ");
        int[] secondPlayerSequence = new int[3];
        for (int i = 0; i < 3; i++) {
            secondPlayerSequence[i] = scanner.nextInt();
        }

        System.out.print("Enter number of throws: ");
        int throwsNumber = scanner.nextInt();


        ProbabilityResult probabilityResult = probabilityCalculator.calculateProbability(firstPlayerSequence, secondPlayerSequence, throwsNumber);
        System.out.println("First player probability: " + probabilityResult.getFirstPlayerProbability());
        System.out.println("Second player probability: " + probabilityResult.getSecondPlayerProbability());
        System.out.println("Draw probability: " + probabilityResult.getDrawProbability());
    }
}
