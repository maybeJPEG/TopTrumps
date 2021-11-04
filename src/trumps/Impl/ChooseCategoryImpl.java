package trumps.Impl;

import trumps.Card;
import trumps.cardsPlayedList;

public class ChooseCategoryImpl {

    public int[]Card;
    public int[]Category;


    public void chooseCategory(int bestCategory){
        trumps.Card C = new Card(1,2,3,4);
        cardsPlayedList activCards = new cardsPlayedList();
        activCards.addCardsPlayed(C);
        }

}
