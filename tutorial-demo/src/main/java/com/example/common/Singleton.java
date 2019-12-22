package com.example.common;

public class Singleton {
    private static Singleton instance;
    private static Integer index = 0;
    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void add() {
        index++;
    }

    public static Integer getSize() {
        return index;
    }

    public static void main(String[] args) {
        Singleton singletonA = Singleton.getInstance();
        Singleton singletonB = Singleton.getInstance();

        singletonA.add();
        singletonB.add();

        System.out.println("singletonA: " + singletonA.getSize());
        System.out.println("singletonB: " + singletonB.getSize());
    }
}
