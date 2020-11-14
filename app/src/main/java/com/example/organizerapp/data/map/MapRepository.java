package com.example.organizerapp.data.map;


import com.example.organizerapp.model.Card;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapRepository {
    private Map<String, Set<Card>> stringCardMap = new TreeMap<>();

    public Set<Card> getActivities(String day) {
        try {
            Set<Card> cards = stringCardMap.get(day);
            if(cards != null){
                return  cards;
            }else{
                return  new HashSet<>();
            }
        } catch (NullPointerException e) {
            return new HashSet<>();
        }
    }

    public void add(String date, Card card) {
        Set<Card> activities = getActivities(date);
        System.out.println(activities);
        activities.add(card);
        stringCardMap.put(date, activities);
    }

}
