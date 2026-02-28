package com.florebencia.filsaime;

import java.util.HashMap;
import java.util.Map;

public class PowXN {

    public double myPow(double x, int n) {
        // have a cache
        //think of the rule of multiplying powers
        Map<Integer, Double> cache = new HashMap<>();
        cache.put(-1, 1/x);
        cache.put(0, 1.0);
        cache.put(1, x);

        if(cache.containsKey(n)) return cache.get(n);

        //using recursion you would get the next
        return findPow(x, n, cache);
    }

    public double findPow(double x, int n, Map<Integer, Double> map){
        //this has to change depending if it's negative or positive
        int halvedValue = n/2;
        int otherHalf = n - n/2;
        if(map.containsKey(n)) return map.get(n);

        if (map.containsKey(halvedValue) && map.containsKey(otherHalf)){
            double newValue = map.get(halvedValue) * map.get(otherHalf);
            map.put(n, newValue);
            return newValue;
        }

        return findPow(x, halvedValue, map) * findPow(x, otherHalf, map);
    }
}
