package ru.gb.java2.lesson1;

import ru.gb.java2.lesson1.creatures.Activities;
import ru.gb.java2.lesson1.creatures.Cat;
import ru.gb.java2.lesson1.creatures.Human;
import ru.gb.java2.lesson1.creatures.Robot;
import ru.gb.java2.lesson1.obstacles.Obstacle;
import ru.gb.java2.lesson1.obstacles.Racetrack;
import ru.gb.java2.lesson1.obstacles.Wall;

public class MainClass {
    public static void main(String[] args) {
        Object[] creatures = {new Cat("Barsik"),
                              new Human("Vasiliy"),
                              new Robot("WALLE")
        };
        Obstacle[] obstacles = {new Wall(3),
                new Racetrack(800),
                new Wall(1),
                new Racetrack(400)
        };
        for(Object creature:creatures) {
            for (Obstacle obstacle:obstacles) {
                if(creature instanceof Activities){
                    if(obstacle instanceof Wall) {
                        if(!((Activities) creature).jump(((Wall) obstacle))) break;
                    }
                    if(obstacle instanceof Racetrack) {
                        if(!((Activities) creature).run(((Racetrack) obstacle))) break;
                    }
                }
            }
        }
    }
}
