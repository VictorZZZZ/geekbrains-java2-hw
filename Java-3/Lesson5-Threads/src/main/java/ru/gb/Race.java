package ru.gb;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    public static int winner=0;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        stages[stages.length-1].setLast(true);
        this.stages = new ArrayList<Stage>(Arrays.asList(stages));
    }

    public static int getWinner() {
        return winner;
    }

    public static void setWinner(int winner) {
        Race.winner = winner;
    }
}
