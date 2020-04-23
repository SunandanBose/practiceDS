package com.sunandan.LinkedList;

import java.util.*;

public class ClimbingTree {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] aliceRank = new int[alice.length];
        LinkedList<Integer> ll= new LinkedList();
        ll.add(scores[0]);
        for(int i = 1; i < scores.length ; i++){
            if(ll.get(ll.size()-1)!=scores[i])
                ll.add(scores[i]);
            continue;
        }
        int alice_index=alice.length -1;
        int count = 0;
        for(int i=0;i<ll.size();i++){
            if(alice_index <0 ) break;
            if(ll.get(i) <= alice[alice_index]){
                aliceRank[alice.length-1-count ] = i  +1;
                count ++;
                alice_index -- ;
            }
        }
        int max_rank = ll.size();
        if(count != alice.length){
            for(int i = 0; i< alice.length-count; i++){
                aliceRank[i]= ++max_rank;
            }
        }
        return aliceRank;
    }

    private static int getRank(int value, LinkedList<Integer> list){
        int i = 0;
        for(i=0;i<list.size();i++){
            if(list.get(i) <= value  ) break;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for(int i=0;i<n;i++){
            scores[i] = sc.nextInt();
        }
        n = sc.nextInt();
        int[] alice = new int[n];
        for(int i=0;i<n;i++){
            alice[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(climbingLeaderboard(scores,alice)));
    }
}
