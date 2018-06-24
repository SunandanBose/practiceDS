package com.sunandan.RobotGrid;

import java.util.Stack;

public class RobotGrid {

	public static void main(String[] args) {
		int n = 3;
		Stack<Coordinate> stack = new Stack<>();
		int[][] grid = new int[n][n];
		int i = 0, j = 0;
		grid[1][1] = 1;
		grid[2][1] = 1;
		Coordinate startpoint = new Coordinate(0, 0);
		Coordinate root;
		stack.push(startpoint);
		while (!stack.isEmpty()) {
			root = stack.peek();
			i = root.getRow();
			j = root.getColumn();
			if (i == n - 1 && j == n - 1) {
				System.out.println("Destination reached with the following path");
				display(root, stack);
				return;
			}
			if (i + 1 < n && grid[i + 1][j] != 1) {
				stack.push(new Coordinate(i + 1, j));
			} else {
				if ((j + 1 < n) && (grid[i][j + 1] != 1)) {
					stack.push(new Coordinate(i, j + 1));
				} else {
					grid[i][j] = 1;
					stack.pop();
				}
			}

		}
	}

	
	//implementing Queue using a single stack.
	private static void display(Coordinate root, Stack<Coordinate> stack) {
		if (stack.size() < 1) {
			return;
		}
		root = stack.pop();
		display(root , stack);
		System.out.print("["+root.getRow() + " , "+root.getColumn()+"] ,");
	}

	static class Coordinate {
		int row;
		int column;

		public Coordinate(int row, int column) {
			this.row = row;
			this.column = column;
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}

	}

}
