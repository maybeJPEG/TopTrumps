package trumps;

import trumps.Impl.Card;

import java.util.ArrayList;

public class cardsPlayedList {
    ArrayList<Card> cardsPlayedList;

    public cardsPlayedList(){
        cardsPlayedList = new ArrayList<Card>();
    }
    public void addCardsPlayed(Card C){
        cardsPlayedList.add(C);
    }
    /**
     * List of Cards whos Categories are being compared. As long as no player has chosen a Category,
     * which is higher than the other players Category, Cards get added to this list.
     */
}
