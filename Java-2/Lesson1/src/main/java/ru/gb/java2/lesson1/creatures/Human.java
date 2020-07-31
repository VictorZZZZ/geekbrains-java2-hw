package ru.gb.java2.lesson1.creatures;

import ru.gb.java2.lesson1.obstacles.Obstacle;
import ru.gb.java2.lesson1.obstacles.Racetrack;
import ru.gb.java2.lesson1.obstacles.Wall;

public class Human implements Activities {
    public static final int MAX_JUMP_HEIGHT = 5;
    public static final int MAX_RUN_LENGTH = 500;
    private String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public boolean run(Racetrack racetrack){
        if(racetrack.getLength()<=MAX_RUN_LENGTH) {
            System.out.printf("%s %s overcome the racetrack(%dm) successfully.%n", this.getClass().getSimpleName(), name,racetrack.getLength());
            return true;
        } else {
            System.out.printf("%s %s did not overcome the racetrack(%dm).%n", this.getClass().getSimpleName(), name,racetrack.getLength());
            return false;
        }
    }

    @Override
    public boolean jump(Wall wall){
        if(wall.getHeight()<=MAX_JUMP_HEIGHT) {
            System.out.printf("%s %s overcome the wall(%dm) successfully.%n", this.getClass().getSimpleName(), name,wall.getHeight());
            return true;
        } else {
            System.out.printf("%s %s did not overcome the wall(%dm).%n", this.getClass().getSimpleName(), name,wall.getHeight());
            return false;
        }
    }
}
