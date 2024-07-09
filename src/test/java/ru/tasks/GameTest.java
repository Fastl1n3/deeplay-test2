package ru.tasks;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class GameTest {

    @Test
    public void testProbability() {
        ProbabilityCalculator probabilityCalculator = new ProbabilityCalculator(1_000_000);

        ProbabilityResult probabilityResult = probabilityCalculator.calculateProbability(new int[]{1, 2, 3}, new int[]{4, 5, 6}, 12);

        double eps = 0.005;
        Assertions.assertEquals(probabilityResult.getFirstPlayerProbability(), 0.044, eps);
        Assertions.assertEquals(probabilityResult.getSecondPlayerProbability(), 0.044, eps);
        Assertions.assertEquals(probabilityResult.getDrawProbability(), 0.91, eps);
    }

    @Test
    public void testProbability2() {
        ProbabilityCalculator probabilityCalculator = new ProbabilityCalculator(1_000_000);

        ProbabilityResult probabilityResult = probabilityCalculator.calculateProbability(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 12);

        double eps = 0.005;
        Assertions.assertEquals(probabilityResult.getFirstPlayerProbability(), 0.0, eps);
        Assertions.assertEquals(probabilityResult.getSecondPlayerProbability(), 0.0, eps);
        Assertions.assertEquals(probabilityResult.getDrawProbability(), 1.0, eps);
    }

}
