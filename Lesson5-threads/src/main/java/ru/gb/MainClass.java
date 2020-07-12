package ru.gb;

public class MainClass {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        straightCount();
        System.out.printf("Time of straight method: %dms %n",System.currentTimeMillis()-start);
        //second method
        start = System.currentTimeMillis();
        threadsCount();
        System.out.printf("Time of threads method: %dms %n",System.currentTimeMillis()-start);
    }


    private static void straightCount(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        calc(arr,0,arr.length-1);
        System.out.println("Straight");
        System.out.printf("%f %f %f ... %f%n",arr[0],arr[1],arr[2],arr[arr.length-1]);
    }

    private static void threadsCount(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        float[] a1 =new float[h];
        float[] a2 =new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h+1, a2, 0, h);

        CalcInThread t1 = new CalcInThread(a1,0,h);
        CalcInThread t2 = new CalcInThread(a2,h+1,arr.length-1);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h+1, h);
            System.out.printf("%f %f %f ... %f%n",arr[0],arr[1],arr[2],arr[arr.length-1]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void calc(float[] arr,int startIndex,int endIndex){
        for (int i = startIndex; i < endIndex; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
