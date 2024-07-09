package ru.tasks;

import lombok.Getter;

@Getter
public class ProbabilityResult {

    private final double firstPlayerProbability;
    private final double secondPlayerProbability;
    private final double drawProbability;

    public ProbabilityResult(double firstPlayerProbability, double secondPlayerProbability, double drawProbability) {
        this.firstPlayerProbability = firstPlayerProbability;
        this.secondPlayerProbability = secondPlayerProbability;
        this.drawProbability = drawProbability;
    }
}
