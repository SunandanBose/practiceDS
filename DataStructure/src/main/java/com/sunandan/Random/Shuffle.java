package com.sunandan.Random;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shuffle<T> {

    public List<T> shuffleList(List<T> list){
        Random random = new Random();
        int random_index;
        if(list.isEmpty()) return Collections.emptyList();
        for(int i=1;i<list.size();i++){
            random_index = random.nextInt(i+1);
            list = swapListData(list,i,random_index);
        }
        return list;
    }

    public List<T> swapListData(List<T> list, int currentPosition, int toSwappedLocation) {
        T temp = list.get(currentPosition);
        list.set(currentPosition,list.get(toSwappedLocation));
        list.set(toSwappedLocation,temp);
        return list;
    }
}
