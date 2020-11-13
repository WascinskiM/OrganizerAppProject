package com.example.organizerapp.data.cards;

import com.example.organizerapp.model.Card;

import java.util.HashSet;
import java.util.Set;

public class ActivityRepository {

   private Set<Card> cards = new HashSet<>();

   ActivityRepository() {
    }

    public void add(Card card){
       cards.add(card);
   }

    public Set<Card> getCards() {
        return cards;
    }

}
