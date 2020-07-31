package ru.gb.java2.lesson1.creatures;

import ru.gb.java2.lesson1.obstacles.Racetrack;
import ru.gb.java2.lesson1.obstacles.Wall;

public interface Activities {
    public boolean run(Racetrack racetrack);
    public boolean jump(Wall wall);
}
