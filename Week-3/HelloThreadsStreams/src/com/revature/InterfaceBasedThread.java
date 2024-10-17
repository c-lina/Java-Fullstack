package com.revature;

public class InterfaceBasedThread implements Runnable{

    //Remember, the run() method defines what our custom Thread does when we run it
    @Override
    public void run() {
        //this method will run through a gor loop and print a message
        //we're going to make some Threads race

        String name = Thread.currentThread().getName();
        System.out.println(name + " has started");

        for(int i = 0; i < 10; i++) {
            System.out.println(name + " is on iteration " + i);

            //Thread.sleep() forces a thread to wait for x amount of milliseconds between runs
            //This method throws InterruptedExecution, which is a Checked Execution
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(name + " has finished");
    }
}
