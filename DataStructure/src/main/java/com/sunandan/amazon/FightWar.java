package com.sunandan.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You have an army with multiple military units
 * Each military unit has a specific amount of power
 * The opponent also has the same number of military units
 * For example:
 * Your Army: [1,5,2,7,8,3,4]
 * Opponent: [4,2,7,9,3,5,7]
 * You have to arrange your army in the best possible way such that you
 * win the most battles and correspondingly the war
 */

public class FightWar {

    public boolean fight(int[] enemyArmy, int[] myArmy) {
        List<Integer> visited = new ArrayList<>();
        Arrays.sort(myArmy);//nlogn
        for (int enemyUnitSize : enemyArmy) {//n* logn
            int myArmySizeIndex = findClosestWinningArmy(myArmy, enemyUnitSize, visited);
            if (myArmySizeIndex >= 0) visited.add(myArmySizeIndex);
        }
        return (visited.size() > (myArmy.length / 2));
    }

    /***
     *29, 30, 32, 35, 37, 39
     * 31
     * mid 35 , 3 s:0 e:2
     * mid 30, 1 s:2 e:2
     * mid 32, 2 s:2 e:1
     */
    private int findClosestWinningArmyBinary(int[] myArmy, int enemyUnitSize, List<Integer> visited, int start, int end) {
        int mid = (start + end) / 2;

        if (enemyUnitSize < myArmy[mid]) {
            if (start > mid - 1)
                if(visited.contains(mid))

                return mid;
            return findClosestWinningArmyBinary(myArmy, enemyUnitSize, visited, start, mid - 1);
        }
        if (enemyUnitSize >= myArmy[mid]) {
            if (mid + 1 > end)
                return -1;
            return findClosestWinningArmyBinary(myArmy, enemyUnitSize, visited, mid + 1, end);
        }

        return -1;
    }

    private int findClosestWinningArmy(int[] myArmy, int enemyUnitSize, List<Integer> visited) {
        for (int i = 0; i < myArmy.length; i++) {
            int myUnitSize = myArmy[i];
            if (visited.contains(i)) continue;
            if (myUnitSize > enemyUnitSize) {
                return i;
            }
        }
        return -1;
    }
}
