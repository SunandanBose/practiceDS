package com.sunandan.google;

import java.util.List;

public class GasStation {

    public int getMinimumStartingGasStation(List<Integer> gasAvailableInStation, List<Integer>  gasNeededToTravelNextStation){
        int gasAvailable = 0;
        int startStation = -1;
        int gasShortage = 0;
        for(int i = 0 ; i < gasAvailableInStation.size(); i++) {
            gasAvailable += gasAvailableInStation.get(i) - gasNeededToTravelNextStation.get(i);
            if(gasAvailable < 0){
                startStation = i+1;
                gasShortage += Math.abs(gasAvailable);
                gasAvailable = 0;
            }
        }
        return gasShortage > gasAvailable ? -1 : startStation;
    }

}
