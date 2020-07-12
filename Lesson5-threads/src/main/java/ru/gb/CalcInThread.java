package ru.gb;

import static ru.gb.MainClass.calc;

public class CalcInThread extends Thread {
    private float[] arr;
    private int startIndex;
    private int endIndex;
    public CalcInThread(float[] arr,int startIndex,int endIndex) {
        this.arr = arr;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        calc(arr,startIndex,endIndex);
    }
}
