package com.example.common;

public class App {

    public static void main(String[] args){
        AppImpl appImpl = new AppImpl();
        int randValue = appImpl.getRandomInt();
        System.out.println(randValue);

        double doubleValue = appImpl.getRandomDouble(0,100);
        System.out.println(doubleValue);
    }
}
