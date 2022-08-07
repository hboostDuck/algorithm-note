package com.orbit.code.lfu;

import java.util.Random;
import java.util.TreeSet;

public class RandomStrategy {
    private Random random = new Random();

    public String route(String serviceKey, TreeSet<String> addressSet) {
        // arr
        String[] addressArr = addressSet.toArray(new String[addressSet.size()]);

        // random
        String finalAddress = addressArr[random.nextInt(addressSet.size())];
        return finalAddress;
    }
}
