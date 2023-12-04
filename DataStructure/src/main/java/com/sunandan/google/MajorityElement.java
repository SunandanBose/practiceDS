package com.sunandan.google;

import java.util.List;

public class MajorityElement<T> {

    public T getMajorityElement(List<T> input){
        int count = 1;
        T majorityElement = input.size() > 0 ? input.get(0) : null;
        for(int i = 1; i<input.size(); i++){
            if(count == 0){
                count ++;
                majorityElement = input.get(i);
            }
            else if(majorityElement == input.get(i)){
                count ++;
            }
            else
                count --;
        }
        return majorityElement;
    }
}
