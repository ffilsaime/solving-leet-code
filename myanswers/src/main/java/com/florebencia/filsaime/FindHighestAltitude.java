package com.florebencia.filsaime;

import java.util.ArrayList;
import java.util.List;

// for leet code problem: https://leetcode.com/problems/find-the-highest-altitude/submissions/1947060457/
public class FindHighestAltitude {

    public int largestAltitude(int[] gain) {
        List<Integer> tracker = new ArrayList<>();
        tracker.add(0);

        if (gain.length == 1){
            return Math.max(0, gain[0]);
        }

        int maxAltitude = 0;
        for (int i = 0; i < gain.length; i++){
            if (i == 0){
                tracker.add(gain[i]);
                maxAltitude = Math.max(maxAltitude, gain[i]);
                continue;
            }

            int altitude = gain[i] + tracker.get(i);
            tracker.add(altitude);
            maxAltitude = Math.max(maxAltitude, altitude);
        }


        return Math.max(0, maxAltitude);
    }
}
