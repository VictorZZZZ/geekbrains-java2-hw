package ru.gb;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
    private boolean isLast = false;
    private boolean isWinnerExists = false;

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public boolean isWinnerExists() {
        return isWinnerExists;
    }

    public void setWinnerExists(boolean winnerExists) {
        isWinnerExists = winnerExists;
    }
}
