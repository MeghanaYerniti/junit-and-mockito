package org.example.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class Business {

    private DataService dataService;

    public int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for(int value:data) {
            if(value > greatestValue)
                greatestValue = value;
        }
        return greatestValue;
    }

}

interface DataService {
    int[] retrieveAllData();
}