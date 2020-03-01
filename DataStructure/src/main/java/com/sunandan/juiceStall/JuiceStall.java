package com.sunandan.juiceStall;

public class JuiceStall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfStalls = 5;
		int[] distofStalls = {10,20,22,23,26};
		int[] juiceQuantity = {10,2,5,1,1};
		int distance = 30;
		int initialEnergy = 10;
		int count = 0;
		int energy = initialEnergy-distofStalls[0];
		int distanceCovered = distofStalls[0];
		for(int i=0;i<numberOfStalls; i++) {
			if(energy < 0) {
				System.out.println("-1");
			}
			else if(i == numberOfStalls-1) {
				if((distance -distanceCovered)>energy) {
					count++;
					energy += juiceQuantity[i];
					distanceCovered += juiceQuantity[i];
				}
				if(distanceCovered >= distance) {
					System.out.println("Total Number of stalls visited : "+count);
					return;
				}
				else {
					System.out.println("abc");
					return;
				}
			}
			else if((distofStalls[i+1]-distofStalls[i])-energy > 0 ) {
				count++;
				energy += juiceQuantity[i];
			}
			energy = energy - (distofStalls[i+1]-distofStalls[i]);
			distanceCovered = distanceCovered + (distofStalls[i+1]-distofStalls[i]);
		}
	}

}
