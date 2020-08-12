package ru.gb;

public class PrintLine {
    //Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
    private static String lastPrinted="C";
    private static final Object mon = new Object();

    private static void printA(){
        try {
            synchronized (mon) {
                while(!lastPrinted.equals("C")){
                    mon.wait();
                }
                System.out.print("A");
                lastPrinted = "A";
                mon.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printB(){
        try{
            synchronized (mon) {
                while(!lastPrinted.equals("A")){
                    mon.wait();
                }
                System.out.print("B");
                lastPrinted = "B";
                mon.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void printC(){
        try {
            synchronized (mon) {
                while(!lastPrinted.equals("B")){
                        mon.wait();
                }
                System.out.print("C");
                lastPrinted = "C";
                mon.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final PrintLine pl = new PrintLine();
        Thread printA = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 4 ; i++) {
                    pl.printA();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread printB = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 4 ; i++) {
                    pl.printB();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread printC = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 4 ; i++) {
                    pl.printC();
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        printB.start();
        printC.start();
        printA.start();


    }

}
