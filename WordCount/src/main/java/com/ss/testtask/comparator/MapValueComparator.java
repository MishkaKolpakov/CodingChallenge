package com.ss.testtask.comparator;

import java.util.Comparator;
import java.util.Map;

public class MapValueComparator implements Comparator<String> {
    private Map<String, Integer> unsortedMap;

    public MapValueComparator(Map<String, Integer> unsortedMap) {
        this.unsortedMap = unsortedMap;
    }

    @Override
    public int compare(String a, String b) {
        if(unsortedMap.get(a) >= unsortedMap.get(b)){
            return -1;
        }else{
            return 1;
        }
    }
}
