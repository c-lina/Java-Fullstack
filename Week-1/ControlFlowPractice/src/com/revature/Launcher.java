package com.revature;

public class Launcher {
    public static void main(String[] args) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String current = "";
        for(int i = 0; i < days.length; i++) {
            current = days[i];
            System.out.println(current);
            if((current.charAt(0) == 'T') || (current.charAt(0) == 'S')) {
                System.out.println("Go to the gym");
            }
            else {
                System.out.println("Stay home");
            }
        }

    }

}
