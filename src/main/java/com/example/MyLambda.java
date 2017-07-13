package com.example;

public class MyLambda {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
            }
        };

        Thread thread = new Thread(runnable);

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2");
            }
        });

        Thread thread3 = new Thread(() -> System.out.println("thread 3"));

        thread.start();
        thread2.start();
        thread3.start();

    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println();
    }
}
