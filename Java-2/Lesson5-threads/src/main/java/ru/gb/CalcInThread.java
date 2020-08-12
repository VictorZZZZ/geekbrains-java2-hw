package ru.gb;

import static ru.gb.MainClass.calc;

public class CalcInThread extends Thread {
    private float[] arr;
    private int offset;
    public CalcInThread(float[] arr,int offset) {
        this.arr = arr;
        this.offset = offset;
    }

    @Override
    public void run() {
        calc(arr,offset);
    }
}
