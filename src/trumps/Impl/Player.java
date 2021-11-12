package trumps.Impl;

import trumps.Exceptions.NotExistentValueException;
import trumps.Impl.Card;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Card actual_card;

    public Player(String name) throws NotExistentValueException {
        this.name = name;
        this.distributeCards();
        this.update_actual_card();
    }

    private void update_actual_card(){
        this.actual_card = this.cards.get(0);
    }

    private void add_active_cards(){
        delete_actual_card_from_list();
        replace_actual_card_in_activeCards();
        update_actual_card();
    }

    private void replace_actual_card_in_activeCards() {
    }

    private void delete_actual_card_from_list() {
    }

    private void distributeCards() throws NotExistentValueException {
        for(int i = 0; i < 20; i++){
            Card card = new Card(i, this);
            this.cards.add(card);
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getActual_card() {
        return actual_card;
    }

}