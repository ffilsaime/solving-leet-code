package com.florebencia.filsaime;

import com.florebencia.filsaime.implement.RecentCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecentCounterTest {

    @Test
    void pingSingleTest(){
        RecentCounter recentCounter = new RecentCounter();
        int answer = recentCounter.ping(1);
        Assertions.assertEquals(1, answer);
    }

    @Test
    void pingTest(){
        RecentCounter recentCounter = new RecentCounter();
        int answer = recentCounter.ping(1);
        int answer2 = recentCounter.ping(100);
        int answer3 = recentCounter.ping(3001);
        int answer4 = recentCounter.ping(3002);
        Assertions.assertEquals(1, answer);
        Assertions.assertEquals(2, answer2);
//        recentCounter.printQueue();
        Assertions.assertEquals(3, answer3);
        Assertions.assertEquals(3, answer4);
//        recentCounter.printQueue();
    }
}
