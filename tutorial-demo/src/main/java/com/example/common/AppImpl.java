package com.example.common;

import java.util.Random;

public class AppImpl implements AppService{
    @Override
    public int getRandomInt() {
        return new Random().nextInt(100);
    }

    @Override
    public double getRandomDouble(double min, double max) {
        return new Random().nextDouble()*(max - min) + min;
    }
}
