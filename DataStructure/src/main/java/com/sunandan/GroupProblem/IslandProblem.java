package com.sunandan.GroupProblem;

import java.io.*;

public class IslandProblem{
    public static void main(String[] args) {
        IslandProblem ip = new IslandProblem();
        int[][] grid = {{1,0,1,1,1},{0,0,0,1,0},{0,1,1,0,0},{0,1,1,0,1}};
        System.out.println(ip.countClusters(grid));
    }
    int xdir[]={0,1,0,-1};
    int ydir[]={1,0,-1,0};
    public int countClusters(int[][] grid){
        int clusterCount = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    visited[i][j] = true;
                    clusterCount ++;
                    for(int dir=0;dir<4;dir++){
                        visited = markNeighboursAsVisited(grid,visited,i+xdir[dir],j+ydir[dir]);
                    }
                } 
            }
        }
        return clusterCount;
    }

    private boolean[][] markNeighboursAsVisited(int[][] grid, boolean[][] visited, int row, int column) {
        if(row >= 0 && column >= 0 && row<grid.length && column < grid[row].length
                && grid[row][column] == 1 && !visited[row][column]){
                    visited[row][column] = true; 
                    for(int dir=0;dir<4;dir++){
                        visited = markNeighboursAsVisited(grid,visited,row+xdir[dir],column+ydir[dir]);
                    }
        }
        return visited;
    }
}