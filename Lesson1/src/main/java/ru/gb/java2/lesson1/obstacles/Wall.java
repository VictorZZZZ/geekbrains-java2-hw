package ru.gb.java2.lesson1.obstacles;

public class Wall extends Obstacle {
    public int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
