package ru.tasks;

public class ProbabilityCalculator {

    private final int EXPERIMENTS_COUNT;

    public ProbabilityCalculator(int experimentsCount) {
        EXPERIMENTS_COUNT = experimentsCount;
    }

    /**
     * Метод, подсчитывающий вероятность побед или ничьи игроков.
     * Применяется метод Монте-Карло. Для этого проводится EXPERIMENTS_COUNT экспериментов
     * и считается количество побед, далее вычисляются примерные вероятности.
     *
     * @param firstPlayerSequence последовательность первого игрока
     * @param secondPlayerSequence последовательность второго игрока
     * @param throwsNumber количество бросков кубика
     * @return объект, содержащий вероятности победы или ничьей
     */
    public ProbabilityResult calculateProbability(int[] firstPlayerSequence, int[] secondPlayerSequence, int throwsNumber) {
        Game game = new Game();

        int firstPlayerPoints = 0;
        int secondPlayerPoints = 0;
        int draw = 0;

        for (int i = 0; i < EXPERIMENTS_COUNT; i++) {
            GameResult gameResult = game.play(firstPlayerSequence, secondPlayerSequence, throwsNumber);

            switch (gameResult) {
                case FIRST_PLAYER_WIN -> firstPlayerPoints++;
                case SECOND_PLAYER_WIN -> secondPlayerPoints++;
                case DRAW -> draw++;
            }
        }

        return new ProbabilityResult((double) firstPlayerPoints / EXPERIMENTS_COUNT,
                (double) secondPlayerPoints / EXPERIMENTS_COUNT,
                (double) draw / EXPERIMENTS_COUNT);

    }
}
