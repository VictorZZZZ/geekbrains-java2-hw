package ru.gb;

import java.util.Arrays;

public class MainClass {
    static final int size = 10_000_000;
    static final int h = size / 2;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        float[] straightArr= straightCount();
        System.out.printf("Time of straight method: %dms %n",System.currentTimeMillis()-start);
        //second method
        start = System.currentTimeMillis();
        float[] threadsArr = threadsCount();
        System.out.printf("Time of threads method: %dms %n",System.currentTimeMillis()-start);
        System.out.println("Results equals = "+Arrays.equals(straightArr,threadsArr));
    }


    private static float[] straightCount(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        calc(arr,0);
        return arr;
    }

    private static float[] threadsCount(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        float[] a1 =new float[h];
        float[] a2 =new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        CalcInThread t1 = new CalcInThread(a1,0);
        CalcInThread t2 = new CalcInThread(a2,h);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static void calc(float[] arr,int offset){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f+(i+offset) / 5) * Math.cos(0.2f + (i+offset) / 5) * Math.cos(0.4f + (i+offset) / 2));
        }
    }
}
