package ru.tasks;

import java.util.Arrays;
import java.util.Random;

public class Game {

    private final int SIDES_COUNT = 6;

    private final Random random = new Random();


    /**
     * Метод, запускающий игру и возвращающий результат игры
     *
     * @param firstPlayerSequence последовательность первого игрока
     * @param secondPlayerSequence последовательность второго игрока
     * @param throwsNumber количество бросков кубика
     * @return enum-объект кто победил или ничья
     */
    public GameResult play(int[] firstPlayerSequence, int[] secondPlayerSequence, int throwsNumber) {
        int[] throwsSequence = createThrowsSequence(throwsNumber);

        int firstPlayerPoints = calculatePoints(throwsSequence, firstPlayerSequence, throwsNumber);
        int secondPlayerPoints = calculatePoints(throwsSequence, secondPlayerSequence, throwsNumber);
        if (firstPlayerPoints > secondPlayerPoints) {
            return GameResult.FIRST_PLAYER_WIN;
        }
        else if (firstPlayerPoints < secondPlayerPoints) {
            return GameResult.SECOND_PLAYER_WIN;
        }
        else {
            return GameResult.DRAW;
        }
    }

    /**
     * Метод для подсчета количества очков, набранных игроком в последовательности бросков.
     * Он сравнивает на совпадение подмассив(с текущего индекса и длины как playerSequence) из throwsSequence и массив playerSequence
     * если совпадают, то увеличиваем индекс на длину игрока и увеличиваем счетчик очков, иначе увеличиваем индекс на 1.
     *
     * @param throwsSequence последовательность бросков кубика.
     * @param playerSequence последовательность игрока.
     * @param throwsNumber количество бросков.
     * @return число очков, заработанных игроком.
     */
    private int calculatePoints(int[] throwsSequence, int[] playerSequence, int throwsNumber) {
        int points = 0;
        int i = 0;

        while (i < throwsNumber) {
            boolean flag = true;
            for (int j = 0; j < playerSequence.length; j++) {
                if (i + j >= throwsNumber || throwsSequence[i + j] != playerSequence[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                i += playerSequence.length;
                points++;
            }
            else {
                i++;
            }
        }
        return points;
    }

    /**
     * Метод генерирует рандомную последовательность бросков кубика
     *
     * @param throwsNumber количество бросков кубика.
     * @return последовательность бросков кубика.
     */
    private int[] createThrowsSequence(int throwsNumber) {
        return Arrays.stream(new int[throwsNumber]).map(e -> random.nextInt(SIDES_COUNT) + 1).toArray();
    }
}
