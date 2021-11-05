package trumps.Impl;

import trumps.Impl.Card;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Player(String name){
        this.name = name;
        this.distributeCards();
    }

    private void distributeCards() {
        for(int i = 0; i < 20; i++){
            Card card = new Card(i, this);
            this.cards.add(card);
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}