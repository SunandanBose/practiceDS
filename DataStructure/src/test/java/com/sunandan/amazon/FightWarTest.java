package com.sunandan.amazon;

import org.junit.Test;

import static org.junit.Assert.*;

public class FightWarTest {

    private FightWar fightWar = new FightWar();

    @Test
    public void test1Fight() {
        int[] enemyArmy = {4, 2, 7, 9, 3, 5, 7};
        int[] myArmy = {1, 5, 2, 7, 8, 3, 4};
        assertEquals(true, fightWar.fight(enemyArmy, myArmy));
}

    /**
     * 1,2,,,,,
     *
     * 4, 2, 7, 9, 3, 5, 7
     *
     */

    @Test
    public void test2Fight() {
        int[] enemyArmy = {2, 2};
        int[] myArmy = {1, 1};
        assertEquals(false, fightWar.fight(enemyArmy, myArmy));
    }

    @Test
    public void test3Fight() {
        int[] enemyArmy = {1, 1};
        int[] myArmy = {2, 2};
        assertEquals(true, fightWar.fight(enemyArmy, myArmy));
    }
}